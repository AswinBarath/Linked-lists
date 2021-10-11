package linkedlists_implementations;

public class SinglyLinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(N)
	public void display() {
		System.out.println("------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("------------");
	}

	// O(1)
	public void addLast(int item) {

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

	// O(1)
	public void addFirst(int item) {
		// create a new node
		Node nn = new Node();

		// values update
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			nn.next = this.head;
			this.head = nn;
			this.size++;
		}
	}

	// O(N)
	public void addAt(int item, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid index");
		}
		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {
			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// summary update
			this.size++;

		}
	}

	// O(1)
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		return this.tail.data;
	}

	// O(N)
	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	// O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	// O(N)
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		int rv = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node secLast = getNodeAt(this.size - 2);
			this.tail = secLast;
			this.tail.next = null;
			this.size--;
		}
		return rv;
	}

	// O(N)
	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Linked list is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index");
		}
		if (idx == 0 || this.size == 1) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node ncur = nm1.next;
			Node np1 = ncur.next;

			nm1.next = np1;
			ncur.next = null;

			this.size--;
			return ncur.data;
		}
	}

	// Problems on Linked Lists
	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;
			left++;
			right--;
		}
	}

	public void reversePointers() {

		Node prev = this.head;
		Node curr = prev.next;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// swap head and tail of the class
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		this.tail.next = null;

	}

	public int mid() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public int kthFromEnd(int k) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

}
