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
        Scanner input = Helper.getScanner();
        int userInput = 0;
        String dateStart = "";
        String dateEnd = "";

        do {
            System.out.println("--Choose--\n" +
                    "=============================================================================================" +
                    "\n1-Creat Reservation \n 2-Show Reservation \n 3-Update Reservation \n 4-Delete Reservation \n 5-Exit" +
                    "\n============================================================");


            if (input.hasNextInt()) {
                userInput = input.nextInt();


                switch (userInput) {
                    case 1:
                        Date[] reservationData = Helper.inputAndValidateDates();


                        boolean test = hotel.createReservation(userId,reservationData);
                        break;
                    case 2:
                        HashMap<Integer, List<Reservation>> reservationsMap  = hotel.getReservationsMap();
                        System.out.println(reservationsMap);
                        break;
                    case 3:
                        int RevToUpdate= Helper.getIdReservationFromUser();
                        Date[] updateDate = Helper.inputAndValidateDates();
                        boolean isUpdate = hotel.updateReservation(RevToUpdate,updateDate);
                        break;
                    case 4:
                            int RevToDelete = Helper.getIdReservationFromUser();
                            boolean isDelete = hotel.deleteReservation(RevToDelete);
                            if (isDelete) {
                                System.out.println("Reservation has been deleted");
                            }else {
                                System.out.println("Reservation has not been deleted");
                            }
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
