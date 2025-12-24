package _76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "aa"));

	}

	public static String minWindow(String s, String t) {
		int finaleLeft = -1;
		int finalRight = -1;

		int indexLeft = 0;
		int indexRight = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < t.length(); i++) {
			if(!map.containsKey(t.charAt(i))){
				map.put(t.charAt(i), 0);
			}
			map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
		}

		while (indexRight < s.length()){

		}

		return "";
	}
}
