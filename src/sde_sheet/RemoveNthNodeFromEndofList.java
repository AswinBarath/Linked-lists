package sde_sheet;

import templates.ListNode;

import templates.LinkedList;

class RemoveNthFromEnd {

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

		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		RemoveNthFromEnd remove = new RemoveNthFromEnd();

		head = remove.removeNthFromEnd(head, 4);
		// Print the new LinkedList where we remove 4th from last
		listOp.printList(head);

		head = remove.removeNthFromEndOptimized(head, 2);
		// Print the updated LinkedList where we remove 2nd from last
		listOp.printList(head);
	}
}
