package _258_AddDigits;

public class Solution {
	public static void main(String[] args) {
		System.out.println(addDigits(38));
		System.out.println(addDigits(0));
		System.out.println(addDigits(191));
		System.out.println(addDigits(Integer.MAX_VALUE));
	}

	public static int addDigits(int num) {
		if (num < 10) {
			return num;
		}
		String stringnum = String.valueOf(num);

		num = 0;
		for (int i = 0; i < stringnum.length(); i++) {
			num += (int) (stringnum.charAt(i) - '0');
		}
		return addDigits(num);
	}
}
