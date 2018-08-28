import java.util.Scanner;

/**
 * Class for solution.
 */

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * {It is the constant used in the calculation of roots}.
     */
    private static final double CONSTANT = 4;

    /**
     * Constructs the object.
     */
    private Solution() {
        // Empty Constructor
    }

    /**
     * { It is the main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }

    /**
     * { It is the method for finding the roots }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     *
     * @return     { It returns the roots of the equation }
     */
    public static void roots(final int a, final int b, final int c) {
        double result = -b + Math.sqrt((b * b) - (x() * a * c));
        result /= (2 * a);
        double result1 = -b - Math.sqrt((b * b) - (x() * a * c));
        result1 /= (2 * a);
        System.out.println(result + " " + result1);
    }

    /**
     * { Function to give the constant value }.
     *
     * @return     { description_of_the_return_value }
     */
    public static double x() {
        return CONSTANT;
    }
}
