import java.util.Scanner;
    /**
     * Class for solution.
     */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int highestNumber = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] > highestNumber) {
                highestNumber = numbers[i];
            }
        }
        System.out.println(highestNumber);
    }
}

