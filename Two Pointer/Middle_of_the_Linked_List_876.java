package Two_Pointer;

public class Middle_of_the_Linked_List_876 {
	public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }     
        return slow;
    }
}
