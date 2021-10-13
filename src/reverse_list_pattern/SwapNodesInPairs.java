package reverse_list_pattern;

import templates.LinkedList;
import templates.ListNode;

// Leetcode: https://leetcode.com/problems/swap-nodes-in-pairs/
// Literally similar to Reverse Nodes in k-Group: https://leetcode.com/problems/reverse-nodes-in-k-group/ (only difference is that k=2 here)

public class SwapNodesInPairs {

	public static ListNode swapPairs(ListNode head) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(0, head);

		ListNode pre = dummy, cur = dummy, nex = dummy;

		int count = 0;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}

		while (count >= 2) {
			cur = pre.next;
			nex = cur.next;
			cur.next = nex.next;
			nex.next = pre.next;
			pre.next = nex;
			nex = cur.next;
			pre = cur;
			count -= 2;
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

		head = swapPairs(head);

		// Print the new LinkedList
		listOp.printList(head);

	}

}

// Output:
// -----------
//  LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
// -----------
// -----------
//  LinkedList: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 8 -> 7 -> 10 -> 9 -> null
// -----------

