package Tree;

public class Binary_Tree_Level_Order_Traversal_II_107 {
	//DFS recursion preorder 1ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        helper(res,root,0);
        Collections.reverse(res); //runs in linear time
        return res;
    }
    private void helper(List<List<Integer>> res,TreeNode root,int depth){
        if(root==null) return;    
        //if(depth==res.size())  res.add(0,new ArrayList<Integer>());   //add first of Array is costly
        if(depth==res.size())  res.add(new ArrayList<Integer>());   
        res.get(depth).add(root.val); //place here or at last both works
        helper(res,root.left,depth+1);
        helper(res,root.right,depth+1);        
    }
    
    //Queue Iteration BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;
        Deque<TreeNode> que=new ArrayDeque<>();
        TreeNode cur=null;
        int levNum=0;
        que.offer(root);
        while(!que.isEmpty()){
            levNum=que.size();
            List<Integer> subList=new ArrayList<>();
            while(levNum-->0){
                cur=que.poll();              
                if(cur.left!=null) que.offer(cur.left);
                if(cur.right!=null) que.offer(cur.right);
                subList.add(cur.val);
            }
            //res.add(0,subList);
            res.add(subList);
        }
       Collections.reverse(res);
        return res;
    }
}
