package LinkedLists;

import templates.ListNode;

public class ReverseLL {

	public static void main(String[] args) {
		// Create a Linked List:
		ListNode list = new ListNode();
		for(int i=1; i<=5; i++) {
			list = list.insert(list, i);
		}
		// Print the original LinkedList
		list.printList(list);
		
		list.head = reverseList(list.head);
		// Print the new LinkedList
		list.printList(list);
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

}
