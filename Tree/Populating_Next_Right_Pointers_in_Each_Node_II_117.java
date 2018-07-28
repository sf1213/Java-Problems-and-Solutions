package Tree;

public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {
	//Iteration, One upper-level pointer, Two lower-level pointer, 1ms
	public void connect(TreeLinkNode root) {
        TreeLinkNode cur=root; //upper level iterate node
        TreeLinkNode head=null;//lower lever leftmost node
        TreeLinkNode pre=null; //lower lever iterate node
        while(cur!=null){  //top to bottom            
            while(cur!=null){  //left to right
                if(cur.left!=null){
                    if(head==null)  head=cur.left;
                    else   pre.next=cur.left;
                    pre=cur.left;
                }
                if(cur.right!=null){
                    if(head==null)  head=cur.right;
                    else pre.next=cur.right;
                    pre=cur.right;
                }
                cur=cur.next;
            }
            cur=head;
            head=null;
            pre=null;
        }
    }
	
	//Dummy Head, 1ms
	public void connect(TreeLinkNode root) {
        TreeLinkNode dummy=new TreeLinkNode(0);//dummy
        dummy.next=root;
        TreeLinkNode cur=dummy.next; //upper level iterate node        
        TreeLinkNode pre=dummy;     //lower lever iterate node
        while(cur!=null){             
            if(cur.left!=null){
                pre.next=cur.left;
                pre=pre.next;
            }
            if(cur.right!=null){
                pre.next=cur.right;
                pre=pre.next;
            }
            if(cur.next!=null){
                cur=cur.next;
            }else{    //next level
                cur=dummy.next;
                dummy.next=null; //to end the process
                pre=dummy;
            }
        }
    }
}
