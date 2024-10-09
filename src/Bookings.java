import java.util.Scanner;

public class Bookings {
    public static void main(String[] args) {

        System.out.println("Enter the number of bookings");
        Scanner input = new Scanner(System.in);

        int totalBookings = input.nextInt();

        System.out.println("Enter the bookings, one per line:");

        int i = 1;


        while( i <= totalBookings) {
            String bookingInstance = input.nextLine();
            String newBook = bookingInstance.replace(" ", "");

            if (newBook.length() == 0) {
                continue;
            }
            i++;
        }
    }
}