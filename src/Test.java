import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date from yyyy-MM-dd");

        String date = sc;
    }
}
