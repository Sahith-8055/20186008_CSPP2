import java.util.Arrays;
import java.util.Scanner;
/**
 * Class for show.
 */
class Show {
    /**
     * {Name of the movie}.
     */
    private String moviename;
    /**
     * {Date and time of the show of the movie}.
     */
    private String showdatetime;
    /**
     * {Seats for the show}.
     */
    private String[] seats;

    /**
     * Constructs the object.
     */
    Show() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      moviename1     The moviename 1
     * @param      showdatetime1  The showdatetime 1
     * @param      seats1         The seats 1
     */
    Show(final String moviename1, final String showdatetime1, final String[] seats1) {
        this.moviename = moviename1;
        this.showdatetime = showdatetime1;
        this.seats = seats1;
    }

    /**
     * {Method to get Moviename}.
     *
     * @return     {Movie name}.
     */
    public String getmovieName() {
        return this.moviename;
    }

    /**
     * {Method to get date and time of the show}.
     *
     * @return     {Date and Time}
     */
    public String getdateTime() {
        return this.showdatetime;
    }

    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    public String[] getSeats() {
        return this.seats;
    }

    public String toString() {
        String s = "";
        return s;
    }
}

/**
 * Class for patron.
 */
class Patron {
    /**
     * {Customer Name}.
     */
    private String customername;
    /**
     * {Phone number of the customer}.
     */
    private String mobilenumber;
    /**
     * {Seats bookes by the customer}.
     */
    private String[] bookedseats;

    /**
     * Constructs the object.
     */
    Patron() {
        //Empty.
    }

    /**
     * Constructs the object.
     *
     * @param      customername1  The customername 1
     * @param      mobilenumber1  The mobilenumber 1
     * @param      bookedseats1   The bookedseats 1
     */
    Patron(final String customername1, final String mobilenumber1, final String[] bookedseats1) {
        this.customername = customername1;
        this.mobilenumber = mobilenumber1;
        this.bookedseats = bookedseats1;
    }

    /**
     * {Method to get customer name}.
     *
     * @return     {Customer name}
     */
    public String getcustomerName() {
        return this.customername;
    }

    /**
     * {Method to get mobile number of the customer}.
     *
     * @return     {Mobile number of the customer}
     */
    public String getmobileNumber() {
        return this.mobilenumber;
    }

    /**
     * {Method to get booked seats}.
     *
     * @return     {Booked seats of the customer}.
     */
    public String[] getbookedSeats() {
        return this.bookedseats;
    }

    public String toString() {
        String s = "";
        return s;

    }
}

/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * {Declaring a variable for number of shows}.
     */
    private int showSize;
    /**
     * {Declaring a variable for number of customers}.
     */
    private int patronSize;
    /**
     * {Declaring an array for patrons}.
     */
    private Patron[] patrons;
    /**
     * {Declaring an array for shows}.
     */
    private Show[] shows;

    /**
     * Constructs the object.
     */
    BookYourShow() {
        this.patrons = new Patron[10];
        this.shows = new Show[10];
        this.showSize = 0;
        this.patronSize = 0;
    }

    /**
     * {Method to resize}.
     */
    private void resize() {
        shows = Arrays.copyOf(shows, 2 * showSize);
        patrons = Arrays.copyOf(patrons, 2 * patronSize);
    }
    /**
     * Method to find the number of shows.
     *
     * @return     {Number of shows}.
     */
    public int showSize() {
        return showSize;
    }

    /**
     * {Method to find number of customers}.
     *
     * @return     {Number of customers}.
     */
    public int patronSize() {
        return patronSize;
    }

    /**
     * Adds a show.
     *
     * @param      show  The show
     */
    public void addAShow(final Show show) {
        if (showSize >= shows.length) {
            resize();
        }
        shows[showSize++] = show;
    }
    public void addAPatron(final Patron patron) {
        if (patronSize >= patrons.length) {
            resize();
        }
        patrons[patronSize++] = patron;
    }
    public Show getAShow(final String moviename, final String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getmovieName().equals(moviename)
                && shows[i].getdateTime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
    }
    public void bookAShow(final String moviename, final String datetime, final Patron p) {
        Show avaliableShow = getAShow(moviename, datetime);
        if (avaliableShow != null) {

        } else {
            System.out.println("No show");
        }
    }
    public void printTicket(String moviename, String datetime, String mobileNumber) {
        Show show = getAShow(moviename, datetime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (mobileNumber.equals(patrons[i].getmobileNumber())) {
                    System.out.println(moviename + " " + datetime + " " + mobileNumber);
                } else {
                    System.out.println("Invalid");
                }
            }
        } else {
            System.out.println("No show");
        }
        //Mobile number check, datatime check and moviename check.
    }
    public void showAll() {
        //Prints all show properties.
    }
}

/**
 * Class for solution.
 */
public class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }

    /**
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}