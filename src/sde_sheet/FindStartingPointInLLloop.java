package sde_sheet;

import templates.ListNode;

public class FindStartingPointInLLloop {

	public static ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;
		ListNode entry = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (slow != entry) {
					entry = entry.next;
					slow = slow.next;
				}
				return entry;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		ListNode head = null;

		LinkedListForLoop listOp = new LinkedListForLoop();

		// Create a Linked List 1 to 10 with 3 as loop start point :
		for (int i = 1; i <= 10; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		// pointing last node to node with val 3
		listOp.loopItUp(head, 5);

		ListNode startPoint = detectCycle(head);

		// Print the value of start point of LL Loop
		System.out.println(startPoint.val);
	}

}

class LinkedListForLoop {

	public void loopItUp(ListNode head, int i) {
		while (head.val != i) {
			head = head.next;
		}
		ListNode nodeAti = head;

		while (head.next != null) {
			head = head.next;
		}

		head.next = nodeAti;

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
