import java.util.Scanner;
    /**
     * Class for solution.
     */
public final class Solution {
    /*
    Do not modify this main function.
    */

    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor
    }
    /**
     * { It is the main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }

    /**
     * { Function used to find the power of a number }.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { It returns the value }.
     */
    public static long power(final int base, final int exponent) {
        if (base == 0) {
            return 0;
        } else if (exponent == 1) {
            return base;
        } else {
            return base * (power(base, exponent - 1));
        }
    }
}

