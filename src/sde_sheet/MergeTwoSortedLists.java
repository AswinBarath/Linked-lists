package sde_sheet;

import templates.LinkedList;
import templates.ListNode;

class RecursiveSolution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}

class IterativeSolution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val > l2.val) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		ListNode res = l1;
		while (l1 != null && l2 != null) {
			ListNode tmp = null;
			while (l1 != null && l1.val <= l2.val) {
				tmp = l1;
				l1 = l1.next;
			}
			tmp.next = l2;

			// swap
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		return res;
	}
}

class BruteForceSolution {
	public ListNode addNode(ListNode newList, ListNode oldList) {
		newList.next = new ListNode(oldList.val);
		newList = newList.next;
		return newList;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode l3 = new ListNode();
		ListNode l3Head = l3;

		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				l3 = addNode(l3, l1);
				l1 = l1.next;
			}

			else if (l1.val > l2.val) {
				l3 = addNode(l3, l2);
				l2 = l2.next;
			}

			else if (l1.val == l2.val) {
				l3 = addNode(l3, l2);
				l2 = l2.next;

				l3 = addNode(l3, l1);
				l1 = l1.next;
			}
		}

		while (l1 != null) {
			l3 = addNode(l3, l1);
			l1 = l1.next;
		}

		while (l2 != null) {
			l3 = addNode(l3, l2);
			l2 = l2.next;
		}

		return l3Head.next;
	}
}

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		ListNode l1 = null;
		ListNode l2 = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,3,5] :
		for (int i = 1; i <= 5; i += 2) {
			l1 = listOp.insert(l1, i);
		}
		// Create a Linked List [2,4,6] :
		for (int i = 2; i <= 6; i += 2) {
			l2 = listOp.insert(l2, i);
		}

		// Print the original LinkedList
		listOp.printList(l1);
		listOp.printList(l2);

		RecursiveSolution rs = new RecursiveSolution();
		ListNode l3 = rs.mergeTwoLists(l1, l2);

//		IterativeSolution iter = new IterativeSolution();
//		ListNode l3 = iter.mergeTwoLists(l1, l2);

//		BruteForceSolution bf = new BruteForceSolution();
//		ListNode l3 = bf.mergeTwoLists(l1, l2);

		// Print the new sum LinkedList
		listOp.printList(l3);
	}

}
