package _49_GroupAnagrams;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
		System.out.println(groupAnagrams(new String[]{""}));
		System.out.println(groupAnagrams(new String[]{"a"}));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> mapList = new HashMap();

		if (strs == null || strs.length == 0) {
			return new ArrayList<>(mapList.values());
		}

		for (String s : strs) {
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);

			String key = String.copyValueOf(charArray);
			if (!mapList.containsKey(key)) {
				mapList.put(key, new ArrayList<>());
			}
			mapList.get(key).add(s);
		}
		return new ArrayList<>(mapList.values());
	}
}
