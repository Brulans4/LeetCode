package _3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring(" "));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<>();

		int index1 = 0;
		int index2 = 1;

		int max = 1;
		int tmpMax = 0;

		set.add(s.charAt(index1));
		tmpMax ++;

		while (index2 < s.length()) {
			if (set.contains(s.charAt(index2))){
				set.remove(s.charAt(index1));
				index1 ++;
				tmpMax --;

			}
			else {
				set.add(s.charAt(index2));
				index2++;
				tmpMax ++;
				if (max < tmpMax){
					max = tmpMax;
				}
			}
		}
		return max;
	}
}






















