package LinkedList;

public class Remove_Nth_Node_From_End_of_List_19 {
//two loop, move fast (n+1) step ahead  9ms
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        //fast move n+1 step
        for(int i=0;i<=n;i++)  fast=fast.next;
        while(fast!=null){
        	fast=fast.next;
        	slow=slow.next;
        }
        slow.next=slow.next.next;   
        return dummy.next;
    }
//one pass,nearly the same 8ms
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(head==null) return head;
	        ListNode dummy=new ListNode(0);
	        dummy.next=head;
	        ListNode slow=dummy;
	        ListNode fast=dummy;          
	        while(fast!=null){
	            if(n<0) slow=slow.next;
	        	fast=fast.next;
	        	n--;
	        }
	        slow.next=slow.next.next;   
	        return dummy.next;
	    }
}
