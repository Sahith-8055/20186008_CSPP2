import java.util.Scanner;
/**
 * { item_description }.
 */
public final class FirstLast6 {
    /**
     * Constructs the object.
     */
    private FirstLast6() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int six = 6;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println((array[0] == six) || array[array.length - 1] == six);
    }
}
