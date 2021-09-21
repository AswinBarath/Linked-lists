package reverse_list_pattern;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
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
	}

}