package linkedlists;

public class Client {

	public static void main(String[] args) {

		try {
			LinkedList list = new LinkedList();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
