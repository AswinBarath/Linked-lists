package sde_sheet;

import templates.ListNode;

public class IntersectionOfTwoLL {

	public ListNode interectionOfTwoLL(ListNode head1, ListNode head2) {

		if (head1 == null || head2 == null)
			return null;

		ListNode d1 = head1;
		ListNode d2 = head2;

		while (d1 != d2) {
			// for the end of first iteration, we reset the pointer to head of other LL
			d1 = (d1 == null ? head2 : d1.next);
			d2 = (d2 == null ? head1 : d2.next);

		}

		return d1;
	}

	public static void main(String[] args) {

		ListNode head1 = null;
		ListNode head2 = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head1 = listOp.insert(head1, i);
		}
		// Create a Linked List [8,9,10] :
		for (int i = 8; i <= 10; i++) {
			head2 = listOp.insert(head2, i);
		}

		listOp.insertTwoAtSame(head1, head2, 11);

		// Add more elements in Linked List [50, 60] :
		for (int i = 50; i <= 60; i += 10) {
			head1 = listOp.insert(head1, i);
		}
		// Create a Linked List [70, 80, 90] :
		for (int i = 70; i <= 90; i += 10) {
			head2 = listOp.insert(head2, i);
		}

		// Print the first LinkedList
		System.out.println("LL 1");
		listOp.printList(head1);
		// Print the second LinkedList
		System.out.println("LL 2");
		listOp.printList(head2);

		IntersectionOfTwoLL point = new IntersectionOfTwoLL();

		ListNode intersection = point.interectionOfTwoLL(head1, head2);

		// Print the intersection of LinkedLists
		System.out.println("intersection");
		listOp.printList(intersection);

	}

}

class LinkedList {

	public void insertTwoAtSame(ListNode curr1, ListNode curr2, int data) {
		ListNode new_node = new ListNode(data);
		new_node.next = null;

		ListNode last1 = curr1;
		ListNode last2 = curr2;
		while (last1.next != null && last2.next != null) {
			last1 = last1.next;
			last2 = last2.next;
		}
		last1.next = new_node;
		last2.next = new_node;
		return;
	}

	public ListNode insert(ListNode curr, int data) {

		ListNode new_node = new ListNode(data);
		new_node.next = null;

		if (curr == null) {
//			System.out.println("Head is null check");
			curr = new_node;
		}

		else {
			ListNode last = curr;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}

		return curr;
	}

	public void printList(ListNode curr) {
		ListNode currNode = curr;

		System.out.println("-----------");
		System.out.print("LinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.val + " -> ");
			currNode = currNode.next;
		}

		System.out.println("null");
		System.out.println("-----------");
	}
}
