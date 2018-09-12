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
    Show(final String moviename1, final String showdatetime1,
        final String[] seats1) {
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

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += moviename + "," + showdatetime + ",";
        s += Arrays.toString(seats).replace(", ",",");
        return s;
    }

    /**
     * {Method to print movie name and date & time of show}.
     *
     * @return     {String}
     */
    public String exceptTickets() {
        String s = "";
        s += moviename + "," + showdatetime;
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
    Patron(final String customername1, final String mobilenumber1,
        final String[] bookedseats1) {
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
        final int number = 10;
        this.patrons = new Patron[number];
        this.shows = new Show[number];
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

    /**
     * Adds a patron.
     *
     * @param      patron  The patron
     */
    public void addAPatron(final Patron patron) {
        if (patronSize >= patrons.length) {
            resize();
        }
        patrons[patronSize++] = patron;
    }

    /**
     * Method to check the avaliability of show.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviename, final String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getmovieName().equals(moviename)
                && shows[i].getdateTime().equals(datetime)) {
                return shows[i];
            }
        }
        return null;
    }

    /**
     * {Method to book a show}.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     * @param      p          {Object of patron class}.
     */
    public void bookAShow(final String moviename, final String datetime,
        final Patron p) {
        addAPatron(p);
        Show avaliableShow = getAShow(moviename, datetime);
        if (avaliableShow != null) {
            String[] seats = avaliableShow.getSeats();
            String[] bookedSeats = p.getbookedSeats();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < bookedSeats.length; j++) {
                    if (seats[i].equals(bookedSeats[j]) && !seats[i].equals("N/A")) {
                        seats[i] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }

    /**
     * {Method to print the ticket for a booked show}.
     *
     * @param      moviename     The moviename
     * @param      datetime      The datetime
     * @param      mobileNumber  The mobile number
     */
    public void printTicket(final String moviename, final String datetime,
        final String mobileNumber) {
        Show show = getAShow(moviename, datetime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (patrons[i].getmobileNumber().equals(mobileNumber)) {
                    System.out.println(mobileNumber + " " + moviename + " " + datetime);
                    return;
                }
            }
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid");
        }
    }

    /**
     * Method to display all the shows.
     */
    public void showAll() {
        //Prints all show properties.
        for (int i = 0; i < showSize; i++) {
            System.out.println(shows[i]);
        }
    }
}

/**
 * Class for solution.
 */
public final class Solution {

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
                       System.out.println(show.exceptTickets());
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