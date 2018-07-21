package LinkedList;

public class Palindrome_Linked_List_234 {
	//mess up List
	public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;//pre is always one step slower than cur
        ListNode cur=head; //cur is always end with slow
        //even:fast end up at null, odd: fast end up at last node
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            cur.next=pre;
            pre=cur;
            cur=slow;
        }
        if(fast!=null) slow=slow.next; //odd
        while(pre!=null){
            if(pre.val!=slow.val) return false;
            slow=slow.next;
            pre=pre.next;
        }
        return true;
    }
	//play nice
	public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=null;//pre is always one step slower than cur
        ListNode cur=head; //cur is always end with slow
        //even:fast end up at null, odd: fast end up at last node
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            cur.next=pre;
            pre=cur;
            cur=slow;
        }
        if(fast!=null) slow=slow.next; //odd
        while(pre!=null){
            if(pre.val!=slow.val) return false;
            ListNode after=pre.next; //restore
            pre.next=cur;
            cur=pre;
            pre=after;          
            slow=slow.next;
        }
        return true;
    }
}
