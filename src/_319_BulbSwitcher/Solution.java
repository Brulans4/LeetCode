package _319_BulbSwitcher;

class Solution {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " -> " + bulbSwitch(i));
		}

		System.out.println();

		for (int i = 0; i < 20; i++) {
			System.out.println(i + " -> " + bulbSwitchBiss(i));
		}
	}

	public static int bulbSwitch(int n) {
		for (int i = 0; i * i < Integer.MAX_VALUE; i++) {
			if (i * i > n) {
				return i-1;
			}
		}
		return -1;
	}

	public static int bulbSwitchBiss(int n) {
		return (int)(Math.sqrt(n));
	}
}
