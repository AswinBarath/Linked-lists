package cracking_the_coding_interview;

import templates.ListNode;

import templates.LinkedList;

class ReturnKthFromEnd {

	public ListNode returnKthFromEndOptimized(ListNode head, int n) {

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

		// Return Nth Node from End of List
		return slow.next;
	}

	public ListNode returnKthFromEnd(ListNode head, int n) {
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

		// Runner technique
		while (fast != null && slow != null) {
			fast = fast.next;
			slow = slow.next;
		}

		// Return 1st Node
		if (slow == head) {
			return head;
		}

		// Return Nth Node from End of List
		return slow;
	}
}

public class ReturnKthNodeFromEndofList {

	public static void main(String[] args) {

		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		ReturnKthFromEnd remove = new ReturnKthFromEnd();

		ListNode ListNodeN1 = remove.returnKthFromEnd(head, 2);
		// Print the new LinkedList where we returned 4th from last
		listOp.printList(ListNodeN1);

		ListNode ListNodeN2 = remove.returnKthFromEndOptimized(head, 2);
		// Print the updated LinkedList where we returned 2nd from last
		listOp.printList(ListNodeN2);
	}
}
