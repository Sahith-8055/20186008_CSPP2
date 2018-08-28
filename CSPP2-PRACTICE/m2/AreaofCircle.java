/**
 * AreaofCircle.java.
 * @author     Sahith.
 */
import java.util.Scanner;
    /**
     * {It is a class}.
     */
public final class AreaofCircle {
    /**
     * @variable PIVALUE.
     */
    private static final double PIVALUE = 22 / 7.0;

    /**
     * Constructs the object.
     */
    private AreaofCircle() {
        //I am not using this constructor
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int radius = scan.nextInt();
        System.out.println(area(radius));
    }

    /**
     * { It is used to find the area of the circle }.
     *
     * @param      radius  The radius
     *
     * @return     { description_of_the_return_value }
     */
    public static double area(final int radius) {
        double area = pi() * (radius * radius);
        return area;
    }

    /**
     * { It is used to return the value of pi }.
     *
     * @return     { description_of_the_return_value }
     */
    public static double pi() {
        return PIVALUE;
    }
}
