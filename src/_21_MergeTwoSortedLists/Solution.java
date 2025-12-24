package _21_MergeTwoSortedLists;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		ListNode list1 = null;

		for (int i = 5; i > 0; i -= 2) {
			list1 = new ListNode(i, list1);
		}
		ListNode list2 = null;

		for (int i = 6; i > 1; i -= 2) {
			list2 = new ListNode(i, list2);
		}
		list1 = mergeTwoLists(list1, list2);

		while (list1 != null) {
			System.out.println(list1.val);
			list1 = list1.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode list = null;

		while (list1 != null || list2 != null) {
			if (list1 == null) {
				list = new ListNode(list2.val, list);
				list2 = list2.next;

			} else if (list2 == null) {
				list = new ListNode(list1.val, list);
				list1 = list1.next;

			} else if (list1.val < list2.val) {
				list = new ListNode(list1.val, list);
				list1 = list1.next;

			} else {
				list = new ListNode(list2.val, list);
				list2 = list2.next;
			}
		}
		return reverseList(list);
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
