package _424_LongestRepeatingCharacterReplacement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
		System.out.println(characterReplacement("AABABBA", 1));
		System.out.println(characterReplacement("ABABBA", 2));
	}

	public static int characterReplacement(String s, int k) {
		int index1 = 0;
		int index2 = 0;

		Map<Character, Integer> map = new HashMap<>();
		int size = 0;

		while (index2 < s.length()) {
			if (!map.containsKey(s.charAt(index2))) {
				map.put(s.charAt(index2), 0);
			}
			map.put(s.charAt(index2), map.get(s.charAt(index2)) + 1);

			int i = 0;

			for (int nb: map.values()) {
				if (i < nb){
					i = nb;
				}
			}
			if (index2 + 1 - index1 - i <= k){
				if (size < index2 + 1 - index1){
					size = index2 + 1 - index1;
				}
			}

			else {
				map.put(s.charAt(index1), map.get(s.charAt(index1)) - 1);
				index1 ++;
			}
			index2++;
		}
		return size;
	}
}
