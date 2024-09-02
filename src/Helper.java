import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
    private static Scanner scannerInstance;

    private Helper (){

    }


    public static Scanner getScanner() {
        if (scannerInstance == null) {
            scannerInstance = new Scanner(System.in);
        }
        return scannerInstance;
    }

    public static boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);

        try {
            // Try to parse the date string
            formatter.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }



    public static Date convertToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false); // Ensures strict parsing of the date format

        try {
            // Parse the date string into a Date object
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Date[] inputAndValidateDates() {

        Scanner input = getScanner();
        String dateStart;
        String dateEnd;
        Date startDate = null;
        Date endDate = null;

        while (startDate == null || endDate == null) {
            System.out.println("Enter date start (format: dd-MM-yyyy):");
            dateStart = input.nextLine();
            input.nextLine();

            if (!isValidDateFormat(dateStart)) {
                System.out.println("Invalid date format for start date. Please try again.");
                continue;
            }

            System.out.println("Enter date end (format: dd-MM-yyyy):");
            dateEnd = input.nextLine();
            input.nextLine();

            if (!isValidDateFormat(dateEnd)) {
                System.out.println("Invalid date format for end date. Please try again.");
                continue;
            }

            startDate = convertToDate(dateStart);
            endDate = convertToDate(dateEnd);


            if (startDate != null && endDate != null && startDate.after(endDate)) {
                System.out.println("Error: Start date must be before end date.");
                startDate = null;
                endDate = null;
            }

        }

        return new Date[]{startDate, endDate};
    }

    public static int getIdReservationFromUser() {
        Scanner input = getScanner();
        int id = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter id of reservation:");
                id = input.nextInt();
                validInput = true; // Input is valid, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next();
            }
        }

        return id;
    }


}
