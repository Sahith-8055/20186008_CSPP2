import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Sahith.
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used.
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
        for (int i = 2; i < n; i++) {
            int flag = 0;
            for (int j = i; j >= 1; j--) {
                if (i % j == 0) {
                    flag++;
                }
            }
            if (flag > 2) {
                    if (i % 2 != 0) {
                        System.out.println(i);
                    }
                }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

