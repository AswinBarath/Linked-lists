package linkedlists_implementations;

public class SinglyLinkedListClient {

	public static void main(String[] args) {

		try {
			SinglyLinkedList list = new SinglyLinkedList();
			list.addFirst(10);
			list.addLast(20);
			list.addLast(30);
			list.addFirst(20);
			list.addFirst(10);
			list.addAt(60, 5);

			System.out.println(list.getFirst()); // 10
			System.out.println(list.getLast()); // 60
			System.out.println(list.getAt(3)); // 20
			System.out.println(list.removeFirst()); // 10
			System.out.println(list.removeLast()); // 60
			System.out.println(list.removeAt(1)); // 10

			list.display(); // 20 20 30

			list.reverseData();
			list.display(); // 30 20 20

			list.reversePointers();
			list.display(); // 20 20 30

			list.removeAt(1);
			list.addFirst(10);
			list.display(); // 10 20 30

			System.out.println(list.mid()); // 20

			list.addLast(44);
			list.addLast(55);
			list.addLast(66);
			list.addLast(77);
			list.display(); // 10 20 30 44 55 66 77

			System.out.println(list.kthFromEnd(4)); // 44

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
