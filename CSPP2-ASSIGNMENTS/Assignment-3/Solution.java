import java.util.Scanner;
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result=power(base,exponent);
        System.out.println(result);
	}
	public static long power(int base, int exponent) {
		if (base == 0) {
			return 0;
		} else if(exponent == 0) {
			return 1;
		} else {
			return base * (power(base, exponent - 1));
		}
	}
}

