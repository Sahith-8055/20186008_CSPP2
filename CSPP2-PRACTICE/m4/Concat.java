import java.util.Scanner;
/**
 * { item_description }.
 */
public final class Concat {
    /**
     * Constructs the object.
     */
    private Concat() {
        //Empty Constructor.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        String concatName = "Hello" + " " + name.concat("!");
        System.out.println(concatName);
    }
}
