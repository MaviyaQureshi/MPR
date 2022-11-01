import java.util.*;

class Main {

   /* calculating the values of variables */
   static double gs(double x, double d, double b, double y, double c, double z, double a) {
      x = (d - b * y - c * z) / a;
      return x;
   }

   public static void main(String[] args) {
      int i, n;
      double x, y, z;
      double coeff[] = new double[12];
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

      /* passing the values of equation */
      System.out.print("\n\nEnter number of iterations to be performed: ");
      n = sc.nextInt();
      x = 0;
      y = 0;
      z = 0;
      for (i = 1; i <= n; i++) {
         x = gs(x, d1, b1, y, c1, z, a1);
         y = gs(y, d2, a2, x, c2, z, b2);
         z = gs(z, d3, a3, x, b3, y, c3);
      }

      /* approximating the calculated values */
      System.out.print("\n\nApproximating the values of x,y and z: \n");
      System.out.print("\nApproximate Value of x is: " + Math.round(x));
      System.out.print("\nApproximate Value of y is: " + Math.round(y));
      System.out.print("\nApproximate Value of z is: " + Math.round(z));

   }
}
