import java.util.*;

class Main {

   /* calculating the values of variables */
   static double gs(double x, double d, double b, double y, double c, double z, double a) {
      x = (d - b * y - c * z) / a;
      return x;
   }

   static double approx(double x) {
      double y = Math.round(x);
      return y;
   }

   public static void main(String[] args) {
      int i, n;
      double x, y, z;
      double coeff[];
      coeff = new double[12];
      Scanner sc = new Scanner(System.in);
      System.out.println("\nEnter the coefficients of 3 variables and constants for 3 equations: \n");
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

      /* Displaying the equation */
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

      /* passing the values of equation */
      System.out.print("\n");
      System.out.print("\nEnter number of iterations to be performed: ");
      n = sc.nextInt();
      for (i = 1; i <= n; i++) {
         x = gs(x, d1, b1, y, c1, z, a1);
         y = gs(y, d2, a2, x, c2, z, b2);
         z = gs(z, d3, a3, x, b3, y, c3);
         System.out.print("\nx of iteration " + i);
         System.out.printf(" is: %.3f", x);
         System.out.print("\ny of iteration " + i);
         System.out.printf(" is: %.3f", y);
         System.out.print("\nz  of iteration " + i);
         System.out.printf(" is: %.3f", z);
         System.out.print("\n");
      }

      System.out.print("\n");
      System.out.print("\nThe Value of x is: " + x);
      System.out.print("\nThe Value of y is: " + y);
      System.out.print("\nThe Value of z is: " + z);

      /* approximating the calculated values */
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
   }
}
