package LeetCode;

import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144 {
	//recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        helper(res,root);
        return res;
    }
    public void helper(List<Integer> res,TreeNode root){
        if(root!=null){
            res.add(root.val);
            helper(res,root.left);
            helper(res,root.right);
        }
    }
    
  //Stack iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){return res;}
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
        return res;
    }
    
    //Another Stack iteration, pushing only the right child into the stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null){return res;}
        
        TreeNode cur=root;
        while(cur!=null||!s.isEmpty()){
            if(cur!=null){
                res.add(cur.val);
                if(cur.right!=null) s.push(cur.right);
                cur=cur.left;
            }else{
                cur=s.pop();            
            }
        }
        return res;
    }
    
  //Morris
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        TreeNode pre=null;
        while(root!=null){
            if(root.left==null){
                res.add(root.val);
                root=root.right;
            }else{
                pre=root.left;
                while(pre.right!=null&&pre.right!=root){
                    pre=pre.right;
                }
                if(pre.right==null){
                    res.add(root.val);
                    pre.right=root;
                    root=root.left;
                }else{
                    pre.right=null;
                    root=root.right;
                }
                
            }
        }
        return res;
    }

}
