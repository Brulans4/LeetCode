package _206_ReverseLinkedList;

public class Solution {
	public static void main(String[] args) {

		ListNode list = null;

		for (int i = 0; i < 5; i++) {
			list = new ListNode(i, list);
		}
		list = reverseList(list);

		while (list != null){
			System.out.println(list.val);
			list = list.next;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode list = null;

		while (head != null){
			list = new ListNode(head.val, list);
			head = head.next;
		}
		return list;
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
