package LinkedList;

public class Merge_Two_Sorted_Lists_21 {
	//Iteration 8ms
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return l1==null?l2:l1;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        ListNode c1=l1,c2=l2;
        while(c1!=null&&c2!=null){
            if(c1.val<c2.val){
                cur.next=c1;
                c1=c1.next;
            }else{
                cur.next=c2;
                c2=c2.next;
            }
            cur=cur.next;
        }
        cur.next=c1==null?c2:c1;
        return dummy.next;
    }
    
  //Recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
