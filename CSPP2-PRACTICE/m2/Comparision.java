/**
 * Comparision.java.
 * @author Sahith.
 */
import java.util.Scanner;
    /**
     * { It is a class with the name of comparision}.
     */
public final class Comparision {
    /**
     * Empty Constructor.
     */
    private Comparision() {
        //I am not using this constructor
    }

    /**
     * {It is the main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int varA = scan.nextInt();
        int varB = scan.nextInt();
        if (varA > varB) {
            System.out.println("Bigger");
        } else if (varA == varB) {
            System.out.println("Equal");
        } else {
            System.out.println("Smaller");
        }
    }
}
