package _20_ValidParentheses;

class Solution {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("[]"));
		System.out.println(isValid("{}"));
		System.out.println(isValid("{([])}"));
		System.out.println();

		System.out.println(isValid("{)"));
		System.out.println(isValid("{([)]}"));
		System.out.println();

		System.out.println(isValid("{"));
		System.out.println(isValid("}"));
	}

	public static boolean isValid(String s) {
		char[] array = new char[s.length() + 1];
		int index = 0;

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				array[index] = c;
				index++;
			} else {
				if (index < 1) {
					return false;
				}

				if (c - 1 == array[index - 1] || c - 2 == array[index - 1]) {
					index--;
				}
				else {
					return false;
				}
			}
		}
		return index == 0;
	}
}
