package sde_sheet;

public class CloneLLwith2Pointers {

	public static NodeWith2Pointers copyRandomList(NodeWith2Pointers head) {
		NodeWith2Pointers iter = head;
		NodeWith2Pointers orgNext = head;

		// First round: make copy of each node, and link them together side-by-side in a
		// single list.
		while (iter != null) {
			orgNext = iter.next;

			NodeWith2Pointers copy = new NodeWith2Pointers(iter.val);
			iter.next = copy;
			copy.next = orgNext;

			iter = orgNext;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		// Don't worry about the random node which should be null, because by default null is assigned by Java

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		NodeWith2Pointers pseudoHead = new NodeWith2Pointers(0);
		NodeWith2Pointers copy = pseudoHead;

		while (iter != null) {
			orgNext = iter.next.next;

			// extract the copy
			copy.next = iter.next;

			// restore the original list
			iter.next = orgNext;

			copy = copy.next;
			iter = orgNext;
		}

		return pseudoHead.next;
	}

	public static void main(String[] args) {
		NodeWith2Pointers node1 = new NodeWith2Pointers(1);
		NodeWith2Pointers node2 = new NodeWith2Pointers(2);
		NodeWith2Pointers node3 = new NodeWith2Pointers(3);
		NodeWith2Pointers node4 = new NodeWith2Pointers(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;

		node1.random = node4;
		node2.random = node3;
		node3.random = null;
		node4.random = node2;

		printListNext(node1);
		printListRandom(node1);

		NodeWith2Pointers newNode1 = copyRandomList(node1);

		printListNext(newNode1);
		printListRandom(newNode1);
	}

	public static void printListNext(NodeWith2Pointers curr) {
		NodeWith2Pointers currNode = curr;

		System.out.println("-----------");
		System.out.print("LinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.val + " -> ");
			currNode = currNode.next;
		}

		System.out.println("null");
		System.out.println("-----------");
	}

	public static void printListRandom(NodeWith2Pointers curr) {
		NodeWith2Pointers currNode = curr;

		System.out.println("-----------");
		System.out.print("LinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.val + " -> ");
			currNode = currNode.random;
		}

		System.out.println("null");
		System.out.println("-----------");
	}

}

//Definition for a NodeWith2Pointers
class NodeWith2Pointers {
	int val;
	NodeWith2Pointers next;
	NodeWith2Pointers random;

	public NodeWith2Pointers(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
