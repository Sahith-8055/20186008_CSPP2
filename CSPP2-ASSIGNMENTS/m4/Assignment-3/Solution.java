import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            long res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * { function_description }.
     *
     * @param      s     { String }.
     *
     * @return     { description_of_the_return_value }.
     */
    public static long binaryToDecimal(final String s) {
        int base = 2;
        int sum = 0;
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                k = k + 1;
                System.out.println(k);
            } else {
                sum += Math.pow(base, k);
                k = k + 1;
                System.out.println(sum);
            }
        }
        return sum;
    }
}
