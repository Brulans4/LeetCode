package _881_BoatsToSavePeople;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		System.out.println("2 -> " + numRescueBoats(new int[]{1, 1}, 1));
		System.out.println("1 -> " + numRescueBoats(new int[]{1, 2}, 3));
		System.out.println("3 -> " + numRescueBoats(new int[]{3, 2, 2, 1}, 3));
		System.out.println("4 -> " + numRescueBoats(new int[]{3, 5, 3, 4}, 5));
		System.out.println("3 -> " + numRescueBoats(new int[]{3, 8, 7, 1, 4}, 9));
		System.out.println("2 -> " + numRescueBoats(new int[]{5, 1, 4, 2}, 6));
		System.out.println("3 -> " + numRescueBoats(new int[]{21, 40, 16, 24, 30}, 50));
	}

	public static int numRescueBoats(int[] people, int limit) {
		int boats = 0;
		Arrays.sort(people);

		int i = 0;
		int j = people.length - 1;

		while (i <= j) {
			int sum = people[i] + people[j];

			if (sum <= limit) {
				boats++;

				i++;
				j--;
			} else {
				boats++;
				j--;
			}
		}
		return boats;
	}
}
