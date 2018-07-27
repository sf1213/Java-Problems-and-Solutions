package Tree;

public class Populating_Next_Right_Pointers_in_Each_Node_Premium_116 {
	//Iteration 1, O(n) Space, BFS, Level-order, One queue, 2ms
	public void connect(TreeLinkNode root) {
        Deque<TreeLinkNode> que=new ArrayDeque<>();
        TreeLinkNode pre=null,cur=null;
        int levNum=0;
        if(root!=null) que.offer(root);
        while(!que.isEmpty()){
            pre=null;
            levNum=que.size();
            while(levNum-->0){
                cur=que.pop();
                cur.next=pre;
                pre=cur;
                if(cur.right!=null) que.offer(cur.right);
                if(cur.left!=null) que.offer(cur.left);
            }
        }
    }
	
	//Iteration 2, O(1) space, Two pointer, 0ms
	public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur=root,lev=root;       
        while(lev.left!=null){
           cur=lev;
            while(cur!=null){
                cur.left.next=cur.right;
                if(cur.next!=null)  cur.right.next=cur.next.left;
                cur=cur.next;
            }
           lev=lev.left;           
        }
    }
	
	//Recursion, 0ms
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        if(root.left!=null) { //root has next level
            root.left.next=root.right;
            if(root.next!=null) root.right.next=root.next.left;
        }       
        connect(root.left);
        connect(root.right);
    }
}
