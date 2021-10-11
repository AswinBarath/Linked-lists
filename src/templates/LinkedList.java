package templates;

public class LinkedList {

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

	public static void main(String[] args) {

		// Template for creating a Singly Linked List:

		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);
	}

}
