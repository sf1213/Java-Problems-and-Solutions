package Tree;

public class Path_Sum_II_113 {
	//Recursion, Pre-Order, DFS
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(res,path,root,sum);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> path, TreeNode root, int sum){
        if(root==null) return;
         path.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum) {
            res.add(new ArrayList<>(path));
        }else{
            if(root.left!=null) helper(res,path,root.left,sum-root.val);
            if(root.right!=null) helper(res,path,root.right,sum-root.val);
        }        
        path.remove(path.size()-1);
    }
   //Iteration, Post-Order, One stack 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode cur=root,pre=null;
        int depth=0;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                path.add(cur.val);
                depth+=cur.val;
                cur=cur.left;
            }
            cur=stack.peek();
            
            if(cur.right!=null&&cur.right!=pre){
                cur=cur.right;
            }else{
                if(cur.left==null&&cur.right==null&&depth==sum){
                res.add(new ArrayList<>(path));
                }
                pre=stack.pop();
                path.remove(path.size()-1);
                depth-=pre.val;
                cur=null;               
            }
        }
        return res;
    }
}
