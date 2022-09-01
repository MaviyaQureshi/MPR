import java.util.*;

public class MPR {
    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // GaussianElimination obj = new GaussianElimination();
        System.out.println("Select the choice of your operation:");
        System.out.println(
                "1.Gauss-Elimination method \n2.Gauss-Seidal method \n3.Newton's forward and backward interpolation method \n4.Inverse of a matrix using Gauss-elimination");
        System.out.printf("Enter your choice :");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                GaussianElimination.main(args);
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            default: {
                System.out.printf("Please enter a valid choice : ");
                choice = sc.nextInt();
            }
        }
        sc.close();
    }
}