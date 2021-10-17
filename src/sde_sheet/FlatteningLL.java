package sde_sheet;

import java.util.Scanner;

class Solution {
	Node mergeTwoLists(Node a, Node b) {

		Node temp = new Node(0);
		Node res = temp;

		while (a != null && b != null) {
			if (a.data < b.data) {
				temp.bottom = a;
				temp = temp.bottom;
				a = a.bottom;
			} else {
				temp.bottom = b;
				temp = temp.bottom;
				b = b.bottom;
			}
		}

		if (a != null)
			temp.bottom = a;
		else
			temp.bottom = b;
		return res.bottom;
	}

	Node flatten(Node root) {
		if (root == null || root.next == null) {
			return root;
		}

		// recur for the list on right
		root.next = flatten(root.next);

		// now merge
		root = mergeTwoLists(root, root.next);

		// return the root
		// it will be in turn merged with its left
		return root;
	}
}

class Node {
	int data;
	Node next;
	Node bottom;

	Node(int d) {
		data = d;
		next = null;
		bottom = null;
	}
}

public class FlatteningLL {
	Node head;

	void printList(Node node) {
		// Node temp = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.bottom;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		FlatteningLL list = new FlatteningLL();
		while (t > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;
			int flag = 1;
			int flag1 = 1;
			for (int i = 0; i < N; i++) {
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if (flag == 1) {
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				} else {
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}

				for (int j = 0; j < m; j++) {
					int a = sc.nextInt();
					tempB = new Node(a);
					if (flag1 == 1) {
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					} else {
						preB.bottom = tempB;
						preB = tempB;
					}
				}

			}
			// list.printList();
			Solution g = new Solution();
			Node root = g.flatten(list.head);
			list.printList(root);

			t--;
		}
		sc.close();
	}
}

/*
 * Input:
 * 
 * 1 4 4 2 3 4 5 7 8 30 10 20 19 22 50 28 35 40 45
 * 
 * Output:
 * 
 * 5 7 8 10 19 20 22 28 30 35 40 45 50
 * 
 */