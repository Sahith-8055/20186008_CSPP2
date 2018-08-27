/**
 * Swap.java.
 * @author Sahith.
 */
public final class Swap {
    /**
     * Empty Constructor.
     */
    private Swap() {
        //I am not using this constructor
    }
    /**
     * main function to print swap.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        int a = 2;
        int b = 3;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }
}
