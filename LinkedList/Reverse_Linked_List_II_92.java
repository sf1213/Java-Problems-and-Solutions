package LinkedList;

public class Reverse_Linked_List_II_92 {
//first thought
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m==n) return head;
        int count=0;
        ListNode pre=null;
        ListNode cur=head;
        
        while(++count<m){ //moves cur to index = m    
            pre=cur;
            cur=cur.next;
        }
       ListNode start=cur;//record m node
        //1->2->3->4->5 --> 1<-2<-3<-4 5
        while(count++<=n){
            ListNode after=cur.next;
            cur.next=pre;
            pre=cur;
            cur=after;
        }
        //pre->4, start->2,cur->5
        if(start.next!=null) start.next.next=pre; //1->4
        start.next=cur;//2->5
        if(m==1) return pre;
        return head;  
    }
	//dummy node more concise
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m==n) return head;
        ListNode dummy=new ListNode(0);//dummy
        dummy.next=head;

        ListNode start=dummy;//node before m-node
        
        for(int i=0;i<m-1;i++){ //moves cur to index = m    
            start=start.next;
        }
        ListNode cur=start.next;
        ListNode after=cur.next;
        //1->2->3->4->5 --> 1->3->2->4->5 --> 1->4->3->2->5
        for(int i=0;i<n-m;i++){           
            cur.next=after.next;
            after.next=start.next; 
            start.next=after;//move after to the head position
            after=cur.next;
        }
        return dummy.next;
    }
}
