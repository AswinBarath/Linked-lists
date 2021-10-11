package sde_sheet;

import templates.LinkedList;
import templates.ListNode;

public class LinkedListCycle {

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;
		try {
			while (fast.next != null || fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (slow == fast) {
					return true;
				}
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;
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

		System.out.println(hasCycle(head));

	}

}
