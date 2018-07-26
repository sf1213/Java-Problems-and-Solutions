package Tree;

public class Binary_Tree_Right_Side_View_199 {
	//Recursion, DFS, 1ms
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        subRight(res,root,0);
        return res;
    }
    private void subRight(List<Integer> res,TreeNode root,int depth){
        if(root==null) return;
        if(depth==res.size()){ //first reach this level
            res.add(root.val);
        }
        subRight(res,root.right,depth+1);//right first
        subRight(res,root.left,depth+1);
    }
	
	
	//Iteration, BFS, 2ms
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> que=new ArrayDeque<>();
        if(root!=null) que.offer(root);
        TreeNode cur=null;
        int levNum;
        while(!que.isEmpty()){
            levNum=que.size();
            res.add(que.peek().val);
            List<Integer> levList=new ArrayList<>();
            while(levNum-->0){
                cur=que.poll();
                if(cur.right!=null) que.offer(cur.right);
                if(cur.left!=null) que.offer(cur.left);
            }    
        }
        return res;
    }
}
