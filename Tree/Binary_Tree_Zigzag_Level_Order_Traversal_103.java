package Tree;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
	//Recursion, DFS, 1ms
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res=new ArrayList<>(); //get(index) is constant
	        subZig(res,root,0);
	        return res;
	    }
	    private void subZig(List<List<Integer>> res, TreeNode root, int depth){
	        if(root==null) return;
	        if(depth==res.size()){
	            res.add(new LinkedList<>());//add(0,e) is constant
	            
	        }
	        if(depth%2==0) res.get(depth).add(root.val);
	        else res.get(depth).add(0, root.val);
	        if(root.left!=null) subZig(res,root.left,depth+1);
	        if(root.right!=null) subZig(res,root.right, depth+1);
	        
	    }
	    
	    //Iteration, BFS, 1ms
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> res=new ArrayList<>();
	        if(root==null) return res;
	        Deque<TreeNode> que=new ArrayDeque<>(); //faster than queue-linkedlist
	        TreeNode cur=null;
	        int levNum=0;
	        boolean zigzag=true; //control direction
	        que.offer(root);
	        while(!que.isEmpty()){
	            levNum=que.size();
	            List<Integer> subList=new LinkedList<>();//add(0,e) is constant
	            while(levNum-->0){
	                cur=que.poll();
	                if(zigzag) subList.add(cur.val);
	                else subList.add(0,cur.val);
	                if(cur.left!=null) que.offer(cur.left);
	                if(cur.right!=null) que.offer(cur.right);
	            }
	            zigzag=!zigzag;
	            res.add(subList);
	        }
	        return res;
	    }
	    
}
