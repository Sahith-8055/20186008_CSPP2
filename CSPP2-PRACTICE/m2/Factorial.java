/**
 * Factorial.java.
 * @author Sahith.
 */
import java.util.Scanner;
    /**
     * {It is a class with the name of factorial}.
     */
public final class Factorial {
    /**
     * Empty Constructor.
     */
    private Factorial() {
        //I am not using this constructor
    }

    /**
     * { It is the main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int fact = scan.nextInt();
        System.out.println(factorial(fact));
    }

    /**
     * { It is the function for defining the factorial }.
     *
     * @param      fact  The fact
     *
     * @return     { It returns the value of the factorial }
     */
    public static int factorial(final int fact) {
        if (fact == 0 || fact == 1) {
            return 1;
        } else {
            return fact * factorial(fact - 1);
        }
    }
}
