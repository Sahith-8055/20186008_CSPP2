    /**
     * { item_description }.
     */
public final class ConverttoWhile {
    /**
     * Constructs the object.
     */
    private ConverttoWhile() {
        //Empty constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int number = 2;
        final int limit = 12;
        while (number < limit) {
            System.out.println(number);
            number = number + 2;
        }
        System.out.println("GoodBye!");
    }
}
