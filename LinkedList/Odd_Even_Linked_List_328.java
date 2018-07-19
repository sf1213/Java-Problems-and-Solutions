package LinkedList;

public class Odd_Even_Linked_List_328 {
	//Brital force  time:O(2n) space:O(1)  4ms
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;        
        ListNode last=head;
        int count=0;
        while(last.next!=null&&last.next.next!=null){
            last=last.next.next;
            count++;
        }
        ListNode tail=null;
        if(last.next!=null) tail=last.next;
        ListNode cur=head;
        while(count-->0){
            last.next=cur.next;
            cur.next=cur.next.next;
            last=last.next;
            cur=cur.next;
        }
        last.next=tail;
        return head;
    }
  //One loop time:O(n) space:O(1)
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;        
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;//record even head
        //1.last even,even.next=null 2.last odd,even=null
        while(even!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    
}
