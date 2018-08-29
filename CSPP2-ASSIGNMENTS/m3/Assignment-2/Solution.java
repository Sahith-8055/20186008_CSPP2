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
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        int count1 = 0;
        int count2 = 0;
        final int remainder = 7;
        final int divisor = 10;
        while (i < n) {
            if (i % divisor == remainder) {
                count1 += 1;
            }
            i += 1;
        }
        for (int k = 1; k < n; k++) {
            int k1 = k / divisor;
            if (k1 == remainder) {
                count2 += 1;
            }
        }
        int count = count1 + count2;
        System.out.println(count);
    }
}

