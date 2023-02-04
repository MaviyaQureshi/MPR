import java.util.*;

public class InverseGaussEli {

    public static void main(String[] args) {

        System.out.print("Inverse of a matrix using Gauss-elimination:\n");
        System.out.print("\n");
        int i, j;
        double a, b, c, d, e, x1, y1, z1, x2, y2, z2, x3, y3, z3;
        double data[][] = new double[3][6];
        double inverse[][] = new double[3][3];
        Scanner sc = new Scanner(System.in);

        /* matrix input */
        System.out.print("Enter a matrix(A) for which Inverse has to be found out:\n");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                data[i][j] = sc.nextDouble();
            }
        }

        /* Displaying the matrix */
        System.out.print("\nEntered matrix(A) is:\n");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.print("    " + data[i][j]);
            }
            System.out.print("\n");
        }

        /* creating identity matrix */
        data[0][3] = 1;
        data[0][4] = 0;
        data[0][5] = 0;
        data[1][3] = 0;
        data[1][4] = 1;
        data[1][5] = 0;
        data[2][3] = 0;
        data[2][4] = 0;
        data[2][5] = 1;
        a = data[0][0];
        b = data[1][0];
        c = data[2][0];

        System.out.print("\nMatrix A:I is as follow:\n");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print("    " + data[i][j]);
            }
            System.out.print("\n");
        }

        // making data[1][0]=0
        for (i = 0; i <= 5; i++) {
            data[1][i] = (a * data[1][i]) - (b * data[0][i]);
        }

        // making data[2][0]=0
        for (i = 0; i <= 5; i++) {
            data[2][i] = (a * data[2][i]) - (c * data[0][i]);
        }

        d = data[1][1];
        e = data[2][1];
        // making data[2][1]=0
        for (i = 0; i <= 5; i++) {
            data[2][i] = (d * data[2][i]) - (e * data[1][i]);
        }

        /* upper triangle matrix display */
        System.out.print("\nMatrix A:I after making lower triangle zero:\n");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 5; j++) {
                System.out.print("    " + data[i][j]);
            }
            System.out.print("\n");
        }

        /* calculating the values of variables */
        z1 = data[2][3] / data[2][2];
        y1 = (data[1][3] - data[1][2] * z1) / data[1][1];
        x1 = (data[0][3] - data[0][1] * y1 - data[0][2] * z1) / data[0][0];

        z2 = data[2][4] / data[2][2];
        y2 = (data[1][4] - data[1][2] * z2) / data[1][1];
        x2 = (data[0][4] - data[0][1] * y2 - data[0][2] * z2) / data[0][0];

        z3 = data[2][5] / data[2][2];
        y3 = (data[1][5] - data[1][2] * z3) / data[1][1];
        x3 = (data[0][5] - data[0][1] * y3 - data[0][2] * z3) / data[0][0];

        /* assigning the values to the matrix */
        inverse[0][0] = x1;
        inverse[0][1] = x2;
        inverse[0][2] = x3;
        inverse[1][0] = y1;
        inverse[1][1] = y2;
        inverse[1][2] = y3;
        inverse[2][0] = z1;
        inverse[2][1] = z2;
        inverse[2][2] = z3;

        /* display of the inverse matrix */

        System.out.print("\n");
        System.out.print("\nInverse of matrix A is as follow:\n");
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                System.out.printf(" %.3f   ", inverse[i][j]);
            }
            System.out.print("\n");
        }
    }
}