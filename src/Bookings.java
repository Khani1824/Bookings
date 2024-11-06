import java.util.ArrayList;
import java.util.Scanner;

public class Bookings {
    public static void main(String[] args) {

        ArrayList<Integer> startTimes = new ArrayList<>();
        ArrayList <Integer> endTimes = new ArrayList<>();


        System.out.println("Enter the number of bookings:");
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

            // Calling min_converter method given 10:30 am = 630 and given 12:30 pm = 750
            int newStartTime = min_converter(startTime); // 630
            int newEndTime = min_converter(endTime);// 750

            // Adding the start time and end time values to separate
            startTimes.add(newStartTime);  // [630]
            endTimes.add(newEndTime); // [750]
            i++;
        }

        // Creating a while loop calculate the number of Clashes within the separate arrays
        int clashes = 0;
        int x = 1;
        while( x <= totalBookings) {
            // getting times in my array
            clashes = counter( startTimes, endTimes);
            x++;
        }

        // print statements ( use if statements)
        if (clashes == 0) {
            System.out.println("Good to go !");
        }
        if( 0 < clashes){
            System.out.println("Let's play Sardines! Number of paris that clash: " + clashes);
        }

    }


    // Method takes in a specific time
    public static int min_converter (String time) {

        // Separating hour, minute and suffix
        // Given the time "10:30am"
        int colonIndex = time.indexOf(":"); // Find index position of :
        String hour = time.substring(0, colonIndex); // hour = "10"
        String min = time.substring(colonIndex + 1, colonIndex + 3); // min = "30"
        String suffix = time.substring(colonIndex + 3); // suffix = "am"

        // Converting time from Strings to Integer
        int hourInt = Integer.parseInt(hour); // hourInt = 10
        int minInt = Integer.parseInt(min); // minInt = 30

        // Changing my am/pm suffix into a number
        int suffixInt = 0;
        if ( suffix.equals("am")) { // true
            suffixInt = 0;
        } if (suffix.equals("pm")) {
            suffixInt = 12 * 60;
        } if (suffix.equals("pm") && hour.equals("12")) {
            suffixInt = 0;
        }

       // Calculating the total time in a way that converts time into an Integer
        int totalTime = (hourInt * 60) + minInt + suffixInt;// total time = (10 * 60 )+ 30 + 0 = 630

        return totalTime;
    }


    // Method taking in two
    public static int counter ( ArrayList <Integer>ArrayList1 , ArrayList <Integer> ArrayList2) {

        int i;
        int count = 0;

        for (i = 0; i < ArrayList1.size() - 1; i++) {
            if ((ArrayList1.get(i) < ArrayList2.get(i + 1) &&  ArrayList1.get(i + 1) <= ArrayList1.get(i) ) || (ArrayList2.get(i) < ArrayList2.get(i + 1) &&  ArrayList1.get(i + 1) < ArrayList2.get(i))) {
                count += 1;
            }
        }
        return count;

    }
}

