package runner_pattern;

import templates.ListNode;

class Solution {

	public ListNode removeNthFromEndOptimized(ListNode head, int n) {

		// Dummy Node
		ListNode start = new ListNode();
		start.next = head;

		// Runners
		ListNode slow = start;
		ListNode fast = start;

		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}

		// Runner technique
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		// Delete Nth Node from End of List reference using previous node
		slow.next = slow.next.next;
		return start.next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Negative Edge Case
		if (head == null || head.next == null) {
			return null;
		}

		// Runners
		ListNode slow = head;
		ListNode fast = head;

		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}

		// Previous element of Nth Node from End of List
		ListNode prev = slow;

		// Runner technique
		while (fast != null && slow != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		// Delete 1st Node
		if (slow == head) {
			head = head.next;
			prev.next = null;
			return head;
		}

		// Delete Nth Node from End of List reference using previous node
		prev.next = slow.next;
		return head;
	}
}

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {

		ListNode list = new ListNode();
		for (int i = 1; i <= 5; i++) {
			list = list.insert(list, i);
		}
		list.printList(list);
		Solution s = new Solution();
		list.head = s.removeNthFromEnd(list, 2);
		list.printList(list);
	}
}
