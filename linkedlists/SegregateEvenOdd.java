package linkedlists;

import java.util.Scanner;

class SimpleLinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(N)
	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// O(1)
	public void add(int item) {

		// create a new node
		Node nn = new Node();

		// values update
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0) {
			this.tail.next = nn;
		}

		// summary object update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public void swap(Node slow, Node fast) {
		Node temp = slow.next;
		slow.next = fast.next;
		fast.next = temp;
	}

	// O(N)
	public void segregateEvenOdd() {
		
		if (this.size <= 2)
			return;
		
		Node oh = this.head;
		Node ot = this.head;
		Node eh = this.head.next;
		Node et = this.head.next;
		
		Node temp = et.next;
		
		oh.next = null;
		eh.next = null;

		while (temp != null) {
			ot.next = temp;
			ot = temp;
			temp = temp.next;
			ot.next = null;

			if(temp == null) break;
			
			et.next = temp;
			et = temp;
			temp = temp.next;
			et.next = null;
		}

		ot.next = eh;

	}
}

public class SegregateEvenOdd {

	public static void main(String[] args) {
		try {
			SimpleLinkedList list = new SimpleLinkedList();
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			for (int i = 0; i < n; i++) { // 10
				list.add(in.nextInt()); // 1 2 3 4 5 6 7 8 9 10
			}
			System.out.print("Original List: ");
			list.display(); 
			list.segregateEvenOdd();
			System.out.print("Modified List: ");
			list.display(); // 1 3 5 7 9 2 4 6 8 10
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
