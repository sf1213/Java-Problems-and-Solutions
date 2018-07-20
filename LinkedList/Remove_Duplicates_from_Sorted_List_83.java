package LinkedList;

public class Remove_Duplicates_from_Sorted_List_83 {
	//Iteration 0ms
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==cur.val)
                cur.next=cur.next.next;
            else cur=cur.next;
        }
        return head;
    }
	
	//Recursion 0ms
	public ListNode deleteDuplicates(ListNode head) {
        //head.next==null:if not judge this, in the end, null will be returned
        if(head==null||head.next==null) return head;
        head.next=deleteDuplicates(head.next);
        return head.val==head.next.val? head.next:head;
    }
}
