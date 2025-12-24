package _125_ValidPalindrome;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome("T3sts3t"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
		System.out.println(isPalindrome(" "));
	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left <= right) {
			char leftChar = s.charAt(left);

			if ('A' <= leftChar && leftChar <= 'Z') {
				leftChar = (char) (leftChar - 'A' + 'a');
			}

			if ((leftChar < 'a' || 'z' < leftChar) && (leftChar < '0' || '9' < leftChar)) {
				left++;
				continue;
			}
			char rightChar = s.charAt(right);

			if ('A' <= rightChar && rightChar <= 'Z') {
				rightChar = (char) (rightChar - 'A' + 'a');
			}

			if ((rightChar < 'a' || 'z' < rightChar) && (rightChar < '0' || '9' < rightChar)) {
				right--;
				continue;
			}

			if (rightChar != leftChar) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}
}
