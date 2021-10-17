package sde_sheet;

import templates.LinkedList;
import templates.ListNode;

public class RotateLL {

	public static ListNode rotateRight(ListNode head, int k) {

		// edge cases
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		// compute the length
		ListNode curr = head;
		int len = 1;
		while (curr.next != null) {
			len++;
			curr = curr.next;
		}

		// Extend last node
		curr.next = head;

		// Correct k value with the value to traverse
		k = len - k % len;

		ListNode traverse = head;
		for (int i = 1; i < k; i++) {
			traverse = traverse.next;
		}

		ListNode answer = traverse.next;
		traverse.next = null;

		return answer;

	}

	public static void main(String[] args) {

		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		head = rotateRight(head, 2);

		// Print the new LinkedList
		listOp.printList(head);

	}

}
