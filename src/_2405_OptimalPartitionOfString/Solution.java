package _2405_OptimalPartitionOfString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		System.out.println(partitionString("abacaba"));
		System.out.println(partitionString("ssssss"));
	}

	public static int partitionString(String s) {
		Set<Character> set = new HashSet<Character>();
		int ans = 1;

		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.clear();
				ans++;
			}
			set.add(c);
		}
		return ans;
	}
}
