package _567_PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		System.out.println(checkInclusion("adc", "dcda"));
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
		System.out.println(checkInclusion("a", "ba"));
	}

	public static boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			if (!map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), 0);
			}
			map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
		}
		int index1 = 0;
		int index2 = 0;

		for (; index2 < s1.length(); index2++) {
			if (!map.containsKey(s2.charAt(index2))) {
				map.put(s2.charAt(index2), 0);
			}
			map.put(s2.charAt(index2), map.get(s2.charAt(index2)) - 1);
		}
		index2--;

		if (isEmpty(map)) {
			return true;
		}

		while (index2 < s2.length()) {
			if (!map.containsKey(s2.charAt(index1))) {
				map.put(s2.charAt(index1), 0);
			}
			map.put(s2.charAt(index1), map.get(s2.charAt(index1)) + 1);

			index1++;
			index2++;

			if (index2 < s2.length()) {
				if (!map.containsKey(s2.charAt(index2))) {
					map.put(s2.charAt(index2), 0);
				}
				map.put(s2.charAt(index2), map.get(s2.charAt(index2)) - 1);
			}
			if (isEmpty(map)) {
				return true;
			}

		}
		return isEmpty(map);
	}

	public static boolean isEmpty(Map<Character, Integer> map) {
		for (int i : map.values()) {
			if (i != 0) {
				return false;
			}
		}
		return true;	
	}
}
