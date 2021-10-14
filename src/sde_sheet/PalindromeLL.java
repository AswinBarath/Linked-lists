package sde_sheet;

import templates.LinkedList;
import templates.ListNode;

public class PalindromeLL {

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		// find middle of linked list
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse the right half
		slow.next = reverseList(slow.next);

		// move slow to right half
		slow = slow.next;

		// check for left half right half equal or not
		while (slow != null) {
			if (head.val != slow.val)
				return false;
			head = head.next;
			slow = slow.next;
		}
		return true;
	}

	public static ListNode reverseList(ListNode curr) {
		ListNode pre = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
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

		System.out.println(isPalindrome(head));

		// Print the new LinkedList
		listOp.printList(head);

	}

}
