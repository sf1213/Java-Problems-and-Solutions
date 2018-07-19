package LinkedList;

public class Swap_Nodes_in_Pairs_24 {
	//Iteration Space:O(1) prev->cur->after => prev->after->current eg:dummy-1-2-3-4
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);//dummy
        ListNode pre=dummy;
        dummy.next=head;
        ListNode cur=head;//cur=1
        while(cur!=null&&cur.next!=null){
            ListNode after=cur.next;//after=2
            pre.next=after;//dummy->2
            cur.next=after.next;//1->3
            after.next=cur;//2->1
            pre=cur;//pre=1
            cur=cur.next;//cur=3           
        }
        return dummy.next;
    }
    
  //recursion Space:O(n)  2ms
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode n=head.next;
        head.next=swapPairs(n.next);
        n.next=head;
        return n;
    }
    
}
