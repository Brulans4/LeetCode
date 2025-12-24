package _9_PalindromeNumber;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(11));
		System.out.println(isPalindrome(100000001));
		System.out.println(isPalindrome(1234554321));
		System.out.println(isPalindrome(1234544321));
		System.out.println(isPalindrome(-1));
		System.out.println(isPalindrome(3));
	}

	/* //SOLUTION PLUS EFFICACE !

	public static boolean isPalindrome(int x) {

		int ans = x;

		if (x < 0) {
			return false;
		}
		int revers = 0;

		while (ans != 0) {
			int least = ans % 10;

			revers *= 10;
			revers += least;

			ans /= 10;
		}
		return revers == x;
	}

	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		char[] number = String.valueOf(x).toCharArray();

		int i = 0;
		int lenght = number.length - 1;

		while (i < lenght - i) {
			if (number[i] != number[lenght - i]) {
				return false;
			}
			i++;
		}
		return true;
	}
}
