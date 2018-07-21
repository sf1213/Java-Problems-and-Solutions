package LinkedList;

public class Remove_Duplicates_from_Sorted_List_II_82 {
	//First thought Iteration 1ms
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0==head.val?1:0);//guarantee dummy node is not same as head.
        dummy.next=head;
        ListNode pre=dummy; //last of unduplicated list
        ListNode cur=dummy; //check from pre.next if there will be duplicate
        while(pre.next!=null&&pre.next.next!=null){
            if(pre.next.val==pre.next.next.val){
                cur=pre.next;
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
            }else{
                pre=pre.next;
            }
            
        }
        return dummy.next;
    }
    
  //More concise iteartion 1ms
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0==head.val?1:0);//guarantee dummy node is not same as head.
        dummy.next=head; 
        ListNode pre=dummy; //last of unduplicated list
        ListNode cur=head; //check from pre.next if there will be duplicate
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }//cur stop at last same node
            if(pre.next==cur){ //cur has not moved
                pre=pre.next;
            }else{      //cur has moved
                pre.next=cur.next;
            }
            cur=cur.next;
            
        }
        return dummy.next;
    }
    
  //One loop iteartion 1ms
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0==head.val?1:0);//guarantee dummy node is not same as head.
        dummy.next=head; 
        ListNode start=dummy;//last of unduplicated list
        ListNode pre=dummy; //check from start.next if there will be duplicate
        ListNode cur=head; //pre.next
        while(cur!=null&&cur.next!=null){
            if(pre.val!=cur.val&&cur.val!=cur.next.val){ //find the unique node
                start.next=cur;
                start=start.next;
            }
            pre=pre.next;//move pre and cur forward
            cur=cur.next;          
        }
        //cur stop at the last node
        if(pre.val==cur.val){
            start.next=null;
        }else{
            start.next=cur;
        }
        return dummy.next;
    }
}
