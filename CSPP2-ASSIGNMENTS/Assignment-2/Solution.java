import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {
    /*
    Do not modify this main function.
    */

    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }

    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static void rootsOfQuadraticEquation(int a, int b, int c) {
        double result = -b + Math.sqrt((b * b) - (4 * a * c));
        result /= (2 * a);
        double result1 = -b - Math.sqrt((b * b) - (4 * a * c));
        result1 /= (2 * a);
        System.out.println(result + " " + result1);
    }
}
