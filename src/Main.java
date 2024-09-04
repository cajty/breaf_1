import java.time.LocalDate;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        User user = new User();

        int userId = user.getId();
        String name = user.getName();

        System.out.println("Hello " + name);
        Hotel hotel = new Hotel();
        Scanner input = Helper.getScanner();
        int userInput = 0;



        do {
            System.out.println("\n--Choose--\n" +
                    "========================================================================" +
                    "\n1-Creat Reservation \n 2-Show Reservation " +
                    "\n 3-Update Reservation \n 4-Delete Reservation \n 5-Exit" +
                    "\n========================================================================");


            if (input.hasNextInt()) {
                userInput = input.nextInt();


                switch (userInput) {
                    case 1:

                        LocalDate[] reservationData = Helper.inputAndValidateDates();

                        hotel.createReservation(userId,reservationData);
                        break;
                    case 2:
                        hotel.getReservationsOfUser(userId);
                        break;
                    case 3:
                            int RevToUpdate= Helper.getIdReservationFromUser();
                            LocalDate[] updateDate = Helper.inputAndValidateDates();
                            boolean isUpdate = hotel.updateReservation(RevToUpdate,updateDate,userId);

                            if(isUpdate){
                                System.out.println("Reservation has been updated");
                            }else{
                                System.out.println("Reservation has not been updated");
                            }
                            break;
                    case 4:
                            int RevToDelete = Helper.getIdReservationFromUser();
                            boolean isDelete = hotel.deleteReservation(RevToDelete);
                            if (isDelete) {
                                System.out.println("Reservation has been deleted");
                            }else {
                                System.out.println("Reservation  not found.");
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
