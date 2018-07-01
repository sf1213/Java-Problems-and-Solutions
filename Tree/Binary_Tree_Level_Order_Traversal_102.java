package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {
	//Queue Iteration-BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wraplist=new LinkedList<>();
        if(root==null) return wraplist;
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int levelNum=q.size();
            List<Integer> sublist=new LinkedList<>();
            for(int i=0;i<levelNum;i++){             
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                sublist.add(q.poll().val);
            }
            wraplist.add(sublist);
            
        }
        return wraplist;
    }
	//DFS
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new LinkedList<>();
        helper(res,root,0);
        return res;
    }
    private void helper(List<List<Integer>> res,TreeNode root,int height){
        if(root==null) return;
        if(height>=res.size()){
            res.add(new LinkedList<Integer>());
        }
        
        res.get(height).add(root.val);
        helper(res,root.left,height+1);
        helper(res,root.right,height+1);
    }
}
