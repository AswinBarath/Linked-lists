package LinkedLists;

/* 
** Java program to implement a Singly Linked List
*/

public class ListNode {
	
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	ListNode head;
	public ListNode insert(ListNode list, int data) {
		ListNode new_node = new ListNode(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		}
		
		else {
			ListNode last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new_node;
		}
		
		return list;
	}

	public void printList(ListNode list) {
		ListNode currNode = list.head;
		
		System.out.print("LinkedList: ");
		
		while (currNode != null) {
			System.out.print(currNode.val + " ");
			currNode = currNode.next;
		}
		
		System.out.println();
	}
		
	public static void main(String[] args) {
		
		ListNode list = new ListNode();
		for(int i=1; i<=5; i++) {
			list = list.insert(list, i);
		}
		list.printList(list);
		
//		// Create a Linked List:
//		ListNode list = new ListNode();
//		for(int i=1; i<=5; i++) {
//			list = list.insert(list, i);
//		}
//		// Print the original LinkedList
//		list.printList(list);
	}
	
}
