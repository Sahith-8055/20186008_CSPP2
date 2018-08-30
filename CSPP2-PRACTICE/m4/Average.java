import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
        //Empty constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }
        double sum = 0;
        for (int j = 0; j < numbers.length; j++) {
            sum += numbers[j];
        }
        double average = sum / n;
        System.out.println(average);
    }
}
