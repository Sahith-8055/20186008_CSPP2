/**
 * Solution.java.
 * @author Sahith.
 */
import java.util.Scanner;
    /**
     * { It is a class}.
     */
public final class Solution {
    /**
     * Empty Constructor.
     */
    private Solution() {
        //I am not using this constructor
    }
    /**
     * {It is the main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        areaOfTriangle(base, height);
    }

    /**
     * { Function used to get the area of triangle}.
     *
     * @param      base    The base
     * @param      height  The height
     */
    public static void areaOfTriangle(final int base, final int height) {
        final int half = 0.5;
        double area = half * base * height;
        System.out.println(area);
    }
}



