package linked_list_problems;

import templates.LinkedList;
import templates.ListNode;

class RecursiveSolution_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}
}

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		RecursiveSolution_RemoveLinkedListElements del = new RecursiveSolution_RemoveLinkedListElements();

		del.removeElements(head, 2); // Deleting 3rd node

		// Print from the new LinkedList
		listOp.printList(head);
	}

}
