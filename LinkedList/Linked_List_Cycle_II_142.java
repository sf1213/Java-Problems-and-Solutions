package LinkedList;

public class Linked_List_Cycle_II_142 {
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null){
            if(fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }            
        }

        
        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
