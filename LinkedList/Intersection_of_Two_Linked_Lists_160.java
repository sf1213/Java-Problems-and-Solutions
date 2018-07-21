package LinkedList;

public class Intersection_of_Two_Linked_Lists_160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode a=headA;
        ListNode b=headB;
        //if a & b have different len, then we will stop the loop after second iteration
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }
}
