import java.util.Scanner;
/**
 * Class for solution.
 * @author Sahith.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * { function_description }.
     *
     * @param      s     {String}.
     *
     * @return     {Reverse of a string}.
     */
    public static String reverseString(final String s) {
        String reversestring = "";
        int k = s.length() - 1;
        for (int i = k; i >= 0; i--) {
            reversestring += s.charAt(i);
        }
        return reversestring;
    }
}
