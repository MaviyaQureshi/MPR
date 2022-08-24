package MPR;

import java.util.Scanner;

public class MPR {

    // Function to read matrix
    public static void userMatrix() {
        int m, n, i, j;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the order of matrix (m & n):");
            m = sc.nextInt();
            n = sc.nextInt();

            // Declare the matrix
            int a[][] = new int[m][n];

            // Read the matrix values
            System.out.println("Enter the elements of the matrix");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            // Display the elements of the matrix
            System.out.println("Elements of the matrix are");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    System.out.print(a[i][j] + "  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
        } finally {
            sc.close();
        }
    }

    // Driver code
    public static void main(String[] args) {
        userMatrix();
    }
}