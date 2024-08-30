import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Helper {

    // Method to check if a string is in the "dd-MM-yyyy" format
    public static boolean isValidDateFormat(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false); // Ensures strict parsing of the date format

        try {
            // Try to parse the date string
            formatter.parse(dateStr);
            return true; // If parsing is successful, the format is valid
        } catch (ParseException e) {
            return false; // If parsing fails, the format is invalid
        }
    }

    // Method to convert a string in "dd-MM-yyyy" format to a Date object
    public static Date convertToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false); // Ensures strict parsing of the date format

        try {
            // Parse the date string into a Date object
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle the exception (for example, log it)
            return null; // Return null if parsing fails
        }
    }

    // Method to interact with the user to input, validate, and convert date strings
    public static Date[] inputAndValidateDates() {
        Scanner input = new Scanner(System.in);
        String dateStart;
        String dateEnd;
        Date startDate = null;
        Date endDate = null;

        while (startDate == null || endDate == null) {
            System.out.println("Enter date start (format: dd-MM-yyyy):");
            dateStart = input.nextLine();

            if (!isValidDateFormat(dateStart)) {
                System.out.println("Invalid date format for start date. Please try again.");
                continue;
            }

            System.out.println("Enter date end (format: dd-MM-yyyy):");
            dateEnd = input.nextLine();

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
}
