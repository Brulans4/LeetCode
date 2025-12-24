package _2_AddTwoNumbers;

public class Solution {
	public static void main(String[] args) {
		ListNode l1N4 = new ListNode(9);
		ListNode l1N3 = new ListNode(9, l1N4);
		ListNode l1N2 = new ListNode(9, l1N3);
		ListNode l1N1 = new ListNode(9, l1N2);

		ListNode l2N2 = new ListNode(9);
		ListNode l2N1 = new ListNode(9, l2N2);

		ListNode res = addTwoNumbers(l1N1, l2N1);

		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int i) {
		if (l1 == null && l2 == null && i == 0) {
			return null;
		}
		if (l1 == null && l2 == null){
			return new ListNode(i);
		}
		int res = i;

		if (l1 == null) {
			res += l2.val;

			if (res < 10) {
				return new ListNode(res, addTwoNumbers(null, l2.next, 0));
			}
			return new ListNode(res % 10, addTwoNumbers(null, l2.next, 1));
		}
		res += l1.val;

		if (l2 == null) {
			if (res < 10) {
				return new ListNode(res, addTwoNumbers(l1.next, null, 0));
			}
			return new ListNode(res % 10, addTwoNumbers(l1.next, null, 1));
		}
		res += l2.val;

		if (res < 10) {
			return new ListNode(res, addTwoNumbers(l1.next, l2.next, 0));
		}
		return new ListNode(res % 10, addTwoNumbers(l1.next, l2.next, 1));
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}




