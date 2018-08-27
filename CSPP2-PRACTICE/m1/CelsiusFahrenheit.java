/**
 * Celsius to Farenheit.java.
 * @author Sahith.
 */
public final class CelsiusFahrenheit {
    /**
     * Empty Constructor.
     */
    private CelsiusFahrenheit() {
        //I am not using this constructor
    }
    /**
     * main function to Convert celsius to Fahrenheit.
     * @param args is the parameter for this function
     */
    public static void main(final String[] args) {
        float celsius = 36.9f;
        System.out.println("Fahrenheit :" + ((celsius * 1.8) + 32));
    }
}
