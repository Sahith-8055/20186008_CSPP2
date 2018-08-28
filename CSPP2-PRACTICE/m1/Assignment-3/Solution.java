import java.util.Scanner;
    /**
     * Class for solution.
     */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor
    }

    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        calculateFromDegreesToFarenheit(degreesCelsius);
    }

    /**
     * Calculates the from degrees to farenheit.
     *
     * @param      degreesCelsius  The degrees celsius
     */
    static void calculateFromDegreesToFarenheit(final double degreesCelsius) {
        final float c1 = 1.8f;
        final double c2 = 32;
        double fahrenheit = ((degreesCelsius * c1) + c2);
        System.out.println(fahrenheit);
    }
}
