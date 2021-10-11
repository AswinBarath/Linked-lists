package cracking_the_coding_interview;

import templates.LinkedList;
import templates.ListNode;

class AddTwoNumbersIISolution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		l1 = reverseLL(l1);
		l2 = reverseLL(l2);

		ListNode l3 = new ListNode();
		ListNode l3Head = l3;

		int sum = 0;
		int rem = 0;
		int carry = 0;

		while (l1 != null && l2 != null) {
			sum = carry + l1.val + l2.val;
			rem = sum % 10;
			carry = sum / 10;

			ListNode node = new ListNode(rem);
			l3.next = node;

			sum = 0;

			l1 = l1.next;
			l2 = l2.next;
			l3 = l3.next;
		}

		// If 1st LL has more elements
		if (l1 != null) {
			while (l1 != null) {
				sum = carry + l1.val;
				rem = sum % 10;
				carry = sum / 10;

				ListNode node = new ListNode(rem);
				l3.next = node;

				sum = 0;

				l1 = l1.next;
				l3 = l3.next;
			}
		}

		// If 2nt LL has more elements
		if (l2 != null) {
			while (l2 != null) {
				sum = carry + l2.val;
				rem = sum % 10;
				carry = sum / 10;

				ListNode node = new ListNode(rem);
				l3.next = node;

				sum = 0;

				l2 = l2.next;
				l3 = l3.next;
			}
		}

		// If carry is still left out
		if (carry != 0) {
			while (carry != 0) {
				rem = carry % 10;
				ListNode node = new ListNode(rem);
				l3.next = node;
				carry = carry / 10;
			}
		}

		l3 = reverseLL(l3Head.next);

		return l3;

	}

	public ListNode reverseLL(ListNode curr) {
		ListNode prev = null;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

}

public class AddTwoNumbersII {

	public static void main(String[] args) {

		ListNode l1 = null;
		ListNode l2 = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			l1 = listOp.insert(l1, i);
			l2 = listOp.insert(l2, i);
		}

		// Print the original LinkedList
		listOp.printList(l1);
		listOp.printList(l2);

		AddTwoNumbersIISolution add2numsii = new AddTwoNumbersIISolution();
		ListNode l3 = add2numsii.addTwoNumbers(l1, l2);

		// Print the new sum LinkedList
		listOp.printList(l3);

	}

}
