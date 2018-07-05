package LinkedList;

public class Reverse_Linked_List_206 {
	//Iteration
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while(head!=null){
            //head:cur, newHead:pre, nextNode:next
            ListNode nextNode=head.next;//record next

            head.next=newHead;//cur.next->pre
            newHead=head; //pre->cur
            head=nextNode; //cur->next
        }
        return newHead;
    }
    
  //recursion left->right
    public ListNode reverseList(ListNode head) {
        return helper(head,null);
    }
  //head:cur, newHead:pre, nextNode:next
    private ListNode helper(ListNode head, ListNode newHead){
        if(head==null) return newHead;
        ListNode nextNode=head.next;
        head.next=newHead;
      
        return helper(nextNode,head);
    }
    
  //recursion right->left
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode nextNode=head.next; //record cur:head, next:nextNode
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
