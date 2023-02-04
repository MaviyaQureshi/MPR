import java.util.*;

class Main {

   static double gs(double x, double d, double b, double y, double c, double z, double a) {
      x = (d - b * y - c * z) / a;
      return x;
   }

   static double approx(double x) {
      double y = Math.round(x);
      return y;
   }

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
      Scanner sc = new Scanner(System.in);
      System.out.print("List of operations that can be performed:\n");
      System.out.print("1.Gauss-Elimination method \n2.Gauss-Seidal method");
      System.out.print(
            "\n3.Newton's forward and backward interpolation method \n4.Inverse of a matrix using Gauss-elimination\n");
      System.out.print("\nEnter your choice:");
      int choice = sc.nextInt();
      System.out.print("\n");

      switch (choice) {

         case 1: {
            System.out.print("Guass-Elimination method:\n");
            System.out.print("\n");
            int i, j;
            double a, b, c, d, e, x, y, z;
            double data[][];
            data = new double[3][4];

            // Scanner sc=new Scanner(System.in);
            System.out.print("Enter the coefficients of required Equations:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 3; j++) {
                  data[i][j] = sc.nextDouble();
               }
            }

            System.out.print("\nEntered equations are as follow:\n");
            System.out.print("\n(" + data[0][0]);
            System.out.print(")x+(" + data[0][1]);
            System.out.print(")y+(" + data[0][2]);
            System.out.print(")z=(" + data[0][3]);
            System.out.print(")");

            System.out.print("\n(" + data[1][0]);
            System.out.print(")x+(" + data[1][1]);
            System.out.print(")y+(" + data[1][2]);
            System.out.print(")z=(" + data[1][3]);
            System.out.print(")");

            System.out.print("\n(" + data[2][0]);
            System.out.print(")x+(" + data[2][1]);
            System.out.print(")y+(" + data[2][2]);
            System.out.print(")z=(" + data[2][3]);
            System.out.print(")\n");

            System.out.print("\n");
            System.out.print("\nMatrix A is as follow:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 2; j++) {
                  System.out.print("    " + data[i][j]);
               }
               System.out.print("\n");
            }

            System.out.print("\nMatrix A:B is as follow:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 3; j++) {
                  System.out.print("    " + data[i][j]);
               }
               System.out.print("\n");
            }

            a = data[0][0];
            b = data[1][0];
            c = data[2][0];
            // making data[1][0]=0
            for (i = 0; i <= 3; i++) {
               data[1][i] = (a * data[1][i]) - (b * data[0][i]);
            }

            // making data[2][0]=0
            for (i = 0; i <= 3; i++) {
               data[2][i] = (a * data[2][i]) - (c * data[0][i]);
            }

            d = data[1][1];
            e = data[2][1];
            // making data[2][1]=0
            for (i = 0; i <= 3; i++) {
               data[2][i] = (d * data[2][i]) - (e * data[1][i]);
            }

            System.out.print("\nMatrix A:B after making lower triangle zero:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 3; j++) {
                  System.out.print("    " + data[i][j]);
               }
               System.out.print("\n");
            }
            System.out.print("\n");

            z = data[2][3] / data[2][2];
            y = (data[1][3] - data[1][2] * z) / data[1][1];
            x = (data[0][3] - data[0][1] * y - data[0][2] * z) / data[0][0];

            System.out.print("\nThe Solution is as follow:");
            System.out.print("\nx: " + x);
            System.out.print("\ny: " + y);
            System.out.print("\nz: " + z);
            break;
         }

         case 2: {
            System.out.print("Guass-Seidel method:\n");
            System.out.print("\n");
            int i, n;
            double x, y, z;
            double coeff[];
            coeff = new double[12];
            // Scanner sc=new Scanner(System.in);

            System.out.print("Enter the coefficients of required equations:\n");
            for (i = 0; i < 12; i++) {
               coeff[i] = sc.nextDouble();
            }

            double a1 = coeff[0];
            double b1 = coeff[1];
            double c1 = coeff[2];
            double d1 = coeff[3];
            double a2 = coeff[4];
            double b2 = coeff[5];
            double c2 = coeff[6];
            double d2 = coeff[7];
            double a3 = coeff[8];
            double b3 = coeff[9];
            double c3 = coeff[10];
            double d3 = coeff[11];

            System.out.print("\nEntered equations are as follow:\n");
            System.out.print("\n(" + a1);
            System.out.print(")x+(" + b1);
            System.out.print(")y+(" + c1);
            System.out.print(")z=(" + d1);
            System.out.print(")");

            System.out.print("\n(" + a2);
            System.out.print(")x+(" + b2);
            System.out.print(")y+(" + c2);
            System.out.print(")z=(" + d2);
            System.out.print(")");

            System.out.print("\n(" + a3);
            System.out.print(")x+(" + b3);
            System.out.print(")y+(" + c3);
            System.out.print(")z=(" + d3);
            System.out.print(")\n");

            x = 0;
            y = 0;
            z = 0;

            System.out.print("\n");
            System.out.print("\nEnter number of iterations to be performed: ");
            n = sc.nextInt();
            for (i = 1; i <= n; i++) {
               x = gs(x, d1, b1, y, c1, z, a1);
               y = gs(y, d2, a2, x, c2, z, b2);
               z = gs(z, d3, a3, x, b3, y, c3);
               System.out.print("\nx of iteration " + i);
               System.out.print(" is: " + x);
               System.out.print("\ny of iteration " + i);
               System.out.print(" is: " + y);
               System.out.print("\nz  of iteration " + i);
               System.out.print(" is: " + z);
               System.out.print("\n");
            }

            System.out.print("\n");
            System.out.print("\nThe Value of x is: " + x);
            System.out.print("\nThe Value of y is: " + y);
            System.out.print("\nThe Value of z is: " + z);

            x = approx(x);
            y = approx(y);
            z = approx(z);
            System.out.print("\n");
            System.out.print("\n");
            System.out.print("\nApproximating the values of x,y and z: ");
            System.out.print("\n");
            System.out.print("\nApproximate Value of x is: " + x);
            System.out.print("\nApproximate Value of y is: " + y);
            System.out.print("\nApproximate Value of z is: " + z);
            break;
         }

         case 3: {
            System.out.print("Newton's forward and backward interpolation method:\n");
            System.out.print("\n");
            int c, n, i, j, k, l, factorial;
            double s, s1, a1, h1, u, prod, sum, a, h, d, sum1;
            // Scanner sc= new Scanner(System.in);

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

            System.out.print("\nList of operations that can be performed:");
            System.out.print("\n1.Forward Interpolation \n2.Backward Interpolation\n");

            for (i = 0; i < 3; i++) {
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

                  default:
                     System.out.println("\nInvalid Serial number Entered!!");
               }
            }
            break;
         }

         case 4: {
            System.out.print("Inverse of a matrix using Gauss-elimination:\n");
            System.out.print("\n");
            int i, j;
            double a, b, c, d, e, x1, y1, z1, x2, y2, z2, x3, y3, z3;
            double data[][], inverse[][];
            data = new double[3][6];
            inverse = new double[3][3];

            // Scanner sc=new Scanner(System.in);
            System.out.print("Enter a matrix(A) for which Inverse has to be found out:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 2; j++) {
                  data[i][j] = sc.nextDouble();
               }
            }

            System.out.print("\nEntered matrix(A) is:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 2; j++) {
                  System.out.print("    " + data[i][j]);
               }
               System.out.print("\n");
            }

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

            System.out.print("\nMatrix A:I after making lower triangle zero:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 5; j++) {
                  System.out.print("    " + data[i][j]);
               }
               System.out.print("\n");
            }

            z1 = data[2][3] / data[2][2];
            y1 = (data[1][3] - data[1][2] * z1) / data[1][1];
            x1 = (data[0][3] - data[0][1] * y1 - data[0][2] * z1) / data[0][0];

            z2 = data[2][4] / data[2][2];
            y2 = (data[1][4] - data[1][2] * z2) / data[1][1];
            x2 = (data[0][4] - data[0][1] * y2 - data[0][2] * z2) / data[0][0];

            z3 = data[2][5] / data[2][2];
            y3 = (data[1][5] - data[1][2] * z3) / data[1][1];
            x3 = (data[0][5] - data[0][1] * y3 - data[0][2] * z3) / data[0][0];

            inverse[0][0] = x1;
            inverse[0][1] = x2;
            inverse[0][2] = x3;
            inverse[1][0] = y1;
            inverse[1][1] = y2;
            inverse[1][2] = y3;
            inverse[2][0] = z1;
            inverse[2][1] = z2;
            inverse[2][2] = z3;

            System.out.print("\n");
            System.out.print("\nInverse of matrix A is as follow:\n");
            for (i = 0; i <= 2; i++) {
               for (j = 0; j <= 2; j++) {
                  System.out.print("    " + inverse[i][j]);
               }
               System.out.print("\n");
            }
            break;
         }

         default: {
            System.out.print("\nInvalid serial number entered!!");
         }
      }
   }
}
