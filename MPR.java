import java.util.Scanner;

public class MPR {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Select the choice of your operation:");
        System.out.println(
                "1.Gauss-Elimination method \n2.Gauss-Seidal method \n3.Newton's forward and backward interpolation method \n4.Inverse of a matrix using Gauss-elimination");
        System.out.printf("Enter your choice :");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                gaussElimination();
                break;
            }
            case 2: {
                gaussSeidal();
                break;
            }
            case 3: {
                newtonPolation();
                break;
            }
            case 4: {
                inverseGauss();
                break;
            }
            default: {
                System.out.printf("Please enter a valid choice : ");
                choice = sc.nextInt();
            }
        }
        sc.close();
    }

    // Function for Gauss-Elimmination
    public int gaussElimination() {
        int n, i, j, k;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the order of matrix (m & n):");
            n = sc.nextInt();

            // Declare the matrix
            int a[][] = new int[n][n + 1];

            // Read the matrix values
            System.out.println("Enter the elements of the matrix");
            for (i = 0; i < n; i++) {
                for (j = 0; j < n + 1; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            // Display the elements of the matrix
            System.out.println("Elements of the matrix are");
            for (i = 0; i < n; i++) {
                for (j = 0; j < n + 1; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }

            float c, sum = 0;
            float x[] = new float[10];
            // Loop for making the matrix into an upper triangle matrix
            for (j = 0; j < n; j++) {
                for (i = 0; i < n; i++) {
                    if (i > j) {
                        c = a[i][j] / a[j][j];
                        for (k = 0; k < n + 1; k++) {
                            a[i][k] -= c * a[j][k];
                        }
                    }
                }
            }

            x[n] = a[n][n + 1] / a[n][n];

            // Loop for backward substitution
            for (i = n - 1; i >= 1; i--) {
                sum = 0;
                for (j = i; j < n; j++) {
                    sum += a[i][j] * x[j];
                }
                x[i] = (a[i][n + 1] - sum) / a[i][i];
            }

            System.out.println("The soltuion is :");
            for (i = 0; i < n; i++) {
                System.out.println("x" + i + "=" + x[i]);
            }

        } catch (Exception e) {
        } finally {
            sc.close();
        }
        return 0;
    }

    // Function for Gauss-Seidal
    public static void gaussSeidal() {

    }

    // Function for Newtons forward and backward interpolation
    public static void newtonPolation() {

    }

    // Funtion for Inverse of a matrix using Gauss Elimination
    public static void inverseGauss() {

    }
}