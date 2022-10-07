import java.util.*;

public class NumericalTechniques {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice > 0) {
            System.out.println("\nSelect the choice of your operation:");
            System.out.println(
                    "\n1.Gauss-Elimination method \n2.Gauss-Seidal method \n3.Newton's forward and backward interpolation method \n4.Inverse of a matrix using Gauss-elimination \n5.Traversal of a Sparse Matrix \n6.Exit");
            System.out.printf("Enter your choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Gaussian Elimination Algorithm Test\n");
                    class GaussianElimination {
                        public void solve(double[][] A, double[] B) {
                            int N = B.length;
                            for (int k = 0; k < N; k++) {
                                /** find pivot row **/
                                int max = k;
                                for (int i = k + 1; i < N; i++)
                                    if (Math.abs(A[i][k]) > Math.abs(A[max][k]))
                                        max = i;

                                /** swap row in A matrix **/
                                double[] temp = A[k];
                                A[k] = A[max];
                                A[max] = temp;

                                /** swap corresponding values in constants matrix **/
                                double t = B[k];
                                B[k] = B[max];
                                B[max] = t;

                                /** pivot factor within A and B **/
                                for (int i = k + 1; i < N; i++) {
                                    double factor = A[i][k] / A[k][k];
                                    B[i] -= factor * B[k];
                                    for (int j = k; j < N; j++)
                                        A[i][j] -= factor * A[k][j];
                                }
                            }

                            /** Print upper-triangular **/
                            upperTriangular(A, B);

                            /** back substitution **/
                            double[] solution = new double[N];
                            for (int i = N - 1; i >= 0; i--) {
                                double sum = 0.0;
                                for (int j = i + 1; j < N; j++)
                                    sum += A[i][j] * solution[j];
                                solution[i] = (B[i] - sum) / A[i][i];
                            }
                            /** Print solution **/
                            printSolution(solution);
                        }

                        /** function to print upper-triangular **/
                        public void upperTriangular(double[][] A, double[] B) {
                            int N = B.length;
                            System.out.println("\nUpper Triangular Matrix : ");
                            for (int i = 0; i < N; i++) {
                                for (int j = 0; j < N; j++)
                                    System.out.printf("%.3f ", A[i][j]);
                                System.out.printf("| %.3f\n", B[i]);
                            }
                        }

                        /** function to print solution **/
                        public void printSolution(double[] sol) {
                            int N = sol.length;
                            System.out.println("\nSolution : ");
                            for (int i = 0; i < N; i++)
                                System.out.printf("%.3f ", sol[i]);
                            System.out.println();
                        }
                    }
                    /** Make an object of GaussianElimination class **/
                    GaussianElimination ge = new GaussianElimination();

                    System.out.println("\nEnter number of variables");
                    int N = sc.nextInt();

                    double[] B = new double[N];
                    double[][] A = new double[N][N];

                    System.out.println("\nEnter " + N + " equations coefficients ");
                    for (int i = 0; i < N; i++)
                        for (int j = 0; j < N; j++)
                            A[i][j] = sc.nextDouble();

                    System.out.println("\nEnter " + N + " solutions");
                    for (int i = 0; i < N; i++)
                        B[i] = sc.nextDouble();

                    ge.solve(A, B);
                    break;
                }

                case 2: {
                    Main.main(args);
                    break;
                }

                case 3: {
                    Newton.main(args);
                    break;
                }

                case 4: {
                    InverseGaussEli.main(args);
                    break;
                }

                case 5: {
                    break;
                }

                case 6: {
                    System.out.println("You have successfully exited!!");
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.printf("Please enter a valid choice : ");
                    choice = sc.nextInt();
                }
            }
        }
        sc.close();
    }
}