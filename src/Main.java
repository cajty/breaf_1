import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        // Create a User instance with sample data
        User user = new User(); // Replace with actual User initialization

        int userId = user.getId();
        String name = user.getName();

        System.out.println("Hello " + name);

        Scanner input = new Scanner(System.in);
        int userInput = 0;


        do {
            System.out.println("Choose: 1-Creat Reservation 2-Show Reservation 3-Update Reservation 4-Delete Reservation 5-Exit");


            if (input.hasNextInt()) {
                userInput = input.nextInt();

                switch (userInput) {
                    case 1:
                        System.out.println("Creating reservation...");
                        break;
                    case 2:
                        System.out.println("Showing reservation...");
                        break;
                    case 3:
                        System.out.println("Updating reservation...");
                        break;
                    case 4:
                        System.out.println("Deleting reservation...");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {

                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        } while (userInput != 5);

        input.close();
    }
}
