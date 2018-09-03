import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { var_description }.
     */
    private String data;
    /**
     * { var_description }.
     */
    private String length;
    /**
     * Constructs the object.
     *
     * @param      inputString  The input string
     */
    InputValidator(final String inputString) {
        this.data = inputString;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean validateData() {
        final int num = 6;
        return ((this.data).length() >= num);
    }
}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}

