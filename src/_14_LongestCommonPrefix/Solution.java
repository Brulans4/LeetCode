package _14_LongestCommonPrefix;

public class Solution {
	public static void main(String[] args) {
		System.out.println("\"" + longestCommonPrefix(new String[]{"flower", "flow", "flight"}) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[]{"dog", "racecar", "car"}) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[]{"","b"}) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[]{"aaa","aa","aaa"}) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[]{"c","acc","ccc"}) + "\"");
		System.out.println("\"" + longestCommonPrefix(new String[]{"cir","car"}) + "\"");
	}

	public static String longestCommonPrefix(String[] strs) {
		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			if (prefix.length() == 0 ){
				return "";
			}
			String s = strs[i];
			String tempoPrefix = "";

			if (s.length() == 0 ){
				return "";
			}

			for (int j = 0; j < prefix.length(); j++) {
				if (j == s.length()){
					break;
				}

				if (prefix.charAt(j) != s.charAt(j)){
					tempoPrefix += prefix.charAt(j);
				}
				else {
					break;
				}
			}
			prefix = tempoPrefix;
		}

		return prefix;
	}
}
