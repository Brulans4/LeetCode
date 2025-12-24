package _242_ValidAnagram;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "cat"));
	}

	public static boolean isAnagram(String s, String t) {
		/*
		-----------------------------------------------------
		V1
		-----------------------------------------------------
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 0);
			}
			map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			if (!map.containsKey(t.charAt(i))) {
				return false;
			}
			map.put(t.charAt(i), map.get(t.charAt(i)) - 1);

			if (map.get(t.charAt(i)) == 0){
				map.remove(t.charAt(i));
			}
		}
		return map.isEmpty();


		-----------------------------------------------------
		V2
		-----------------------------------------------------
		if (s.length() != t.length()){
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (!map.containsKey(c1)) {
				map.put(c1, 0);
			}
			map.put(c1, map.get(c1) + 1);

			if (map.get(c1) == 0){
				map.remove(c1);
			}

			char c2 = t.charAt(i);
			if (!map.containsKey(c2)) {
				map.put(c2, 0);
			}
			map.put(c2, map.get(c2) - 1);

			if (map.get(c2) == 0){
				map.remove(c2);
			}
		}
		return map.isEmpty();
		 */
		//-----------------------------------------------------
		//V3
		//-----------------------------------------------------
		if (s.length() != t.length()){
			return false;
		}
		int[] array = new int[26];

		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0){
				return false;
			}
		}
		return true;
	}
}
