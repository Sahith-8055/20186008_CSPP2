import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : Sahith.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] round(final int[][] a, final int rows, final int columns) {
        Scanner scan = new Scanner(System.in);
        final int num1 = 50;
        final int num2 = 100;
        final int num3 = 150;
        final int num4 = 200;
        final int num5 = 250;
        final int num6 = 300;
        final int num7 = 350;
        final int num8 = 400;
        final int num9 = 450;
        final int num10 = 500;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] > 0 && a[i][j] < num1) {
                    a[i][j] = 0;
                } else if (a[i][j] >= num1 && a[i][j] < num3) {
                    a[i][j] = num2;
                } else if (a[i][j] >= num3 && a[i][j] < num5) {
                    a[i][j] = num4;
                } else if (a[i][j] >= num5 && a[i][j] < num7) {
                    a[i][j] = num6;
                } else if (a[i][j] >= num7 && a[i][j] < num9) {
                    a[i][j] = num8;
                } else if (a[i][j] >= num9 && a[i][j] < num10) {
                    a[i][j] = num10;
                }
        }
    }
    return a;
}
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = round(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
