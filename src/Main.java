import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        // Create a User instance with sample data
        User user = new User(); // Replace with actual User initialization

        int userId = user.getId();
        String name = user.getName();

        System.out.println("Hello " + name);
        Hotel hotel = new Hotel();
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        String dateStart = "";
        String dateEnd = "";

        do {
            System.out.println("Choose: \n 1-Creat Reservation \n 2-Show Reservation \n 3-Update Reservation \n 4-Delete Reservation \n 5-Exit");


            if (input.hasNextInt()) {
                userInput = input.nextInt();


                switch (userInput) {
                    case 1:

                        boolean test = hotel.createReservation(userId, dateStart, dateEnd);
                        break;
                    case 2:
                        HashMap<Integer, List<Reservation>> reservationsMap  = hotel.getReservationsMap();
                        System.out.println(reservationsMap);
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
