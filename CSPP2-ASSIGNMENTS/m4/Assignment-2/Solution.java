import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public class Solution {
	static Scanner scan = new Scanner(System.in);
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//Empty constructor.
	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		int m1 = scan.nextInt();
		int m2 = scan.nextInt();
		int[][] matrix1 = matrix(m1, m2);
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int[][] matrix2 = matrix(n1, n2);
		int[][] sum = new int[m1][m2];
		if ((m1 != n1) || (m2 != n2)) {
			System.out.println("not possible");
		} else {
			for (int i = 0; i < m1; i++) {
				for (int j = 0; j < m2; j++) {
					sum[i][j] = matrix1[i][j] + matrix2[i][j];
				}
			}
			for (int k =0; k < m1; k++) {
				for (int l = 0; l < m2-1; l++) {
					System.out.print(sum[k][l] + " ");
				}
				System.out.print(sum[k][m2-1]);
			}
		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      row   The row
	 * @param      col   The col
	 *
	 * @return     { Matrix of size row by col }.
	 */
	public static int[][] matrix(final int row, final int col) {
		int[][] array = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		return array;
	}
}