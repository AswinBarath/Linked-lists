package reverse_list_pattern;

import templates.LinkedList;
import templates.ListNode;

class ReverseBetweenSolution {
    public ListNode reverseBetween(ListNode head, int left, int right) { 
        
        if(left == right) return head;
        
        ListNode tempHead = head;
        int curr = 1;
        
        ListNode prevToStart = null;
        while(left != curr && tempHead != null) {
            prevToStart = tempHead;
            tempHead = tempHead.next;
            curr++;
        }
        ListNode start = tempHead;

        ListNode end = null;
        while(curr <= right && tempHead != null) {
            ListNode next = tempHead.next;
            tempHead.next = end;
            end = tempHead; 
            tempHead = next;
            
            curr++;
        }
        
        ListNode nextToEnd = tempHead;        
        
        if(prevToStart != null) { 
            // when left begins from 2
            prevToStart.next = end;
        }
        if(nextToEnd != null) {
            // when right is not last element
            start.next = nextToEnd;
        }
        
        if(left == 1) {
            head = end;
        }
        
        return head;
    }
}


public class ReverseLLType2 {

	public static void main(String[] args) {
		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);
		
		ReverseBetweenSolution rbs = new ReverseBetweenSolution();

		head = rbs.reverseBetween(head, 2, 4);

		// Print the new LinkedList
		listOp.printList(head);
	}

}