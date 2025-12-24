package _1857_LargestColorValueInADirectedGraph;

import java.util.*;

class Solution {
	public static void main(String[] args) {
		System.out.println(largestPathValue("hhqhuqhqff", new int[][]{{0,1},{0,2},{2,3},{3,4},{3,5},{5,6},{2,7},{6,7},{7,8},{3,8},{5,8},{8,9},{3,9},{6,9}}));
		System.out.println(largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}));

		System.out.println(largestPathValue("aaa", new int[][]{{0, 1}, {1, 2}, {2, 0}}));
		System.out.println(largestPathValue("a", new int[][]{{0, 0}}));
	}

	public static int largestPathValue(String colors, int[][] edges) {
		Map<Character, Integer> colorToCounter = new HashMap<>();
		Set<Integer> checkedNode = new HashSet<>();

		int max = 0;

		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == edges[i][1]) {
				return -1;
			}
			if (checkedNode.contains(edges[i][0]) && checkedNode.contains(edges[i][1])) {
				if (checkedBFS(edges, i)) {
					return -1;
				}
			}

			if (!checkedNode.contains(edges[i][0])) {
				max = addNodeToMapAndSet(colors, colorToCounter, checkedNode, edges[i][0], max);
			}
			if (!checkedNode.contains(edges[i][1])) {
				max = addNodeToMapAndSet(colors, colorToCounter, checkedNode, edges[i][1], max);
			}
		}

		return max;
	}

	private static int addNodeToMapAndSet(String colors, Map<Character, Integer> colorToCounter,
										  Set<Integer> checkedNode, int node, int max) {

		char color = colors.charAt(node);

		if (!colorToCounter.containsKey(color)) {
			colorToCounter.put(color, 0);
		}
		colorToCounter.put(color, colorToCounter.get(color) + 1);

		checkedNode.add(node);

		if (max < colorToCounter.get(color)) {
			return colorToCounter.get(color);
		}
		return max;
	}

	private static boolean checkedBFS(int[][] edges, int index) {
		int root = edges[index][1];
		int toFind = edges[index][0];

		Map<Integer, Integer> bfsMap = new HashMap<>();
		Set<Integer> checkedNode = new HashSet<>();

		Deque<Integer> list = new LinkedList<>();

		do{
			System.out.println(root);
			for (int i = 0; i < edges.length; i++) {
				if (edges[i][0] == root && !checkedNode.contains(root)) {
					bfsMap.put(edges[i][0], edges[i][1]);
					list.addLast(edges[i][1]);
					checkedNode.add(edges[i][0]);
					break;
				}
			}
			root = list.removeFirst();
		}while (!list.isEmpty());

		return bfsMap.containsKey(toFind);
	}
}
