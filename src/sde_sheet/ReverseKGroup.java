package sde_sheet;

import templates.LinkedList;
import templates.ListNode;

public class ReverseKGroup {

	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode dummy = new ListNode(0, head);

		ListNode pre = dummy, cur = dummy, nex = dummy;

		int count = 0;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}

		while (count >= k) {
			cur = pre.next;
			nex = cur.next;
			for (int i = 1; i < k; i++) {
				cur.next = nex.next;
				nex.next = pre.next;
				pre.next = nex;
				nex = cur.next;
			}
			pre = cur;
			count -= k;
		}

		return dummy.next;
	}

	public static void main(String[] args) {

		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 10; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		head = reverseKGroup(head, 3);

		// Print the new LinkedList
		listOp.printList(head);

	}

}

/*
 * Output
 * 
 * -----------
 * LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
 * -----------
 * -----------
 * LinkedList: 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7 -> 10 -> null
 * -----------
 */
