import java.util.Scanner;

public class Bookings {
    public static void main(String[] args) {

        System.out.println("Enter the number of bookings");
        Scanner input = new Scanner(System.in);

        int totalBookings = input.nextInt();

        System.out.println("Enter the bookings, one per line:");

        int i = 1;


        while( i <= totalBookings) {

            // Structure 10:30 am - 12:30 pm
            String bookingInstance = input.nextLine();

            // Remove all white spaces
            String newBook = bookingInstance.replace(" ", "");

            if (newBook.length() == 0) {
                continue;
            }

            // Separating beginning time and ending times by finding dash location
            int dashIndex = newBook.indexOf("-");
            String startTime = newBook.substring(0, dashIndex);
            String endTime = newBook.substring(dashIndex + 1);

            i++;
        }
    }
}