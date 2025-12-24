package _13_RomanToInteger;

public class Solution {
	public static void main(String[] args) {
		System.out.println("3 | " + romanToInt("III"));
		System.out.println();
		System.out.println("4 | " + romanToInt("IV"));
		System.out.println();
		System.out.println("58 | " + romanToInt("LVIII"));
		System.out.println();
		System.out.println("1994 | " + romanToInt("MCMXCIV"));
		System.out.println();
	}

	public static int romanToInt(String s) {
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			int nb1 = getValue(s, i);

			if (i == s.length() - 1) {
				ans += nb1;
			} else {
				int nb2 = getValue(s, i + 1);

				if (nb1 < nb2) {
					ans -= nb1;
				} else {
					ans += nb1;
				}
			}
		}
		return ans;
	}

	private static int getValue(String s, int i) {
		return switch (s.charAt(i)) {
			case 'I' -> 1;
			case 'V' -> 5;
			case 'X' -> 10;
			case 'L' -> 50;
			case 'C' -> 100;
			case 'D' -> 500;
			case 'M' -> 1000;
			default -> 0;
		};
	}
}
