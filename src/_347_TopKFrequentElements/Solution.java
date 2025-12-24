package _347_TopKFrequentElements;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
	}

	public static int[] topKFrequent(int[] nums, int k) {
		if (nums == null) {
			return new int[0];
		}
		Map<Integer, Integer> mapCounter = new HashMap<>();
		Queue<Integer> maxheap = new PriorityQueue<>((a, b) -> mapCounter.get(b) - mapCounter.get(a));

		for (int nb : nums) {
			if (!mapCounter.containsKey(nb)) {
				mapCounter.put(nb, 0);
			}
			mapCounter.put(nb, mapCounter.get(nb) + 1);
		}
		maxheap.addAll(mapCounter.keySet());
		int[] array = new int[k];

		for (int i = 0; i < k; i++) {
			array[i] = maxheap.poll();
		}
		return array;
	}
}
