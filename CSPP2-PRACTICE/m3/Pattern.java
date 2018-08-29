/**
 * { item_description }.
 */
public final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
        //Empty constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int number = 5;
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
