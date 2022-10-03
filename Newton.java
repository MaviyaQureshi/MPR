import java.util.*;

class Newton {

    static int fact(int i) {
        if (i == 0) {
            return 1;
        } else {
            return i * fact(i - 1);
        }
    }

    static double product(double x, int i, int n) {
        int j = i;
        double prod = 1.0;
        for (j = i; j > 0; j--) {
            prod = (x - (j - 1)) * prod;
        }
        return prod;
    }

    static double product1(double x, int i, int n) {
        int j = i;
        double prod = 1.0;
        for (j = i; j > 0; j--) {
            prod = (x + (j - 1)) * prod;
        }
        return prod;
    }

    public static void main(String[] args) {
        int c = 1, n, i, j, k, l, factorial;
        double s, s1, a1, h1, u, prod, sum, a, h, d, sum1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of rows of data:");
        n = sc.nextInt();
        double data[][];
        data = new double[n][n + 1];

        System.out.print("\nEnter Data:");
        System.out.print("\nX:");
        for (i = 0; i < n; i++) {
            data[i][0] = sc.nextDouble();
        }
        System.out.print("\nY:");
        for (i = 0; i < n; i++) {
            data[i][1] = sc.nextDouble();
        }

        k = n + 1;
        l = n;
        for (j = 2; j < k; j++) {
            for (i = 0; i < l - 1; i++) {
                if (i + 1 < l) {
                    data[i][j] = data[i + 1][j - 1] - data[i][j - 1];
                } else {
                    data[i][j] = 00;
                }
            }
            l--;
        }

        System.out.print("\nData arranged in Systematic order:\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n + 1; j++) {
                System.out.print("    " + data[i][j]);
            }
            System.out.print("\n");
        }

        h = data[1][0] - data[0][0];

        while (c != 3) {
            System.out.print("\nList of operations that can be performed:");
            System.out.print("\n1.Forward Interpolation \n2.Backward Interpolation\n3.Exit");
            System.out.print("\nEnter Serial number of operation to be performed:");

            c = sc.nextInt();
            switch (c) {

                // Forward Interpolation
                case 1:

                    System.out.println("\nForward Interpolation:");
                    a = data[0][0];
                    System.out.print("\nEnter the value for which Y has to be calculated:");
                    s = sc.nextDouble();
                    s1 = s;
                    a1 = a;
                    h1 = h;
                    u = (s1 - a1) / h1;
                    sum = data[0][1];
                    sum1 = 0;
                    for (j = 1; j < n; j++) {
                        prod = product(u, j, n);
                        d = data[0][j + 1];
                        factorial = fact(j);
                        sum1 = prod * d / factorial;
                        sum = sum + sum1;
                    }
                    System.out.println("\nThe answer is:" + sum);
                    System.out.println("\nOperation Performed Successfully!!");
                    break;

                // Backward Interpolation
                case 2:

                    System.out.println("\nBackward Interpolation:");
                    a = data[n - 1][0];
                    System.out.print("\nEnter the value for which Y has to be calculated:");
                    s = sc.nextDouble();
                    s1 = s;
                    a1 = a;
                    h1 = h;
                    u = (s1 - a1) / h1;
                    sum = data[n - 1][1];
                    sum1 = 0;
                    for (j = 1; j < n; j++) {
                        prod = product1(u, j, n);
                        d = data[n - (j + 1)][j + 1];
                        factorial = fact(j);
                        sum1 = prod * d / factorial;
                        sum = sum + sum1;
                    }
                    System.out.println("\nThe answer is:" + sum);
                    System.out.println("\nOperation Performed Successfully!!");
                    break;

                case 3:

                    System.exit(0);
                    break;

            }
        }
    }
}