package LinkedList;

public class Add_Two_Numbers_2 {
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode c1=l1;
	        ListNode c2=l2;
	        ListNode dummy=new ListNode(0);     
	        ListNode d=dummy;
	        int sum=0;
	        while(c1!=null||c2!=null||sum!=0){ //sum!=0 is for the last nodes' sum>=10
	            if(c1!=null){
	                sum+=c1.val;
	                c1=c1.next;
	            }
	            if(c2!=null){
	                sum+=c2.val;
	                c2=c2.next;
	            }
	            d.next=new ListNode(sum%10);
	            sum=(sum>=10? 1:0);//move 1 digit to left
	            d=d.next;
	        }
	        return dummy.next;
	    }
}
