package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 {
	//recursion
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(res,root);
        return res;
   }       
       
	public void helper(List<Integer> list, TreeNode root) {
		if (root != null) {
			helper(list, root.left); // be concise, no need to judge if root.left==null, recursion will do
			list.add(root.val);
			helper(list, root.right);
		}
	}
	
	//Stack Iteration
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){    //push all the left node into stack, until reaches the left leaf's child(null)
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();//backtrack to upper level node A
            res.add(node.val); //print A
            cur=node.right;  //switch to A's right leaf                    
        }
        return res;
    }
    
    //or write in a more concise way using one loop
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		while (cur != null || !stack.isEmpty()) {
			if (cur != null) { // push all the left node into stack, until reaches the left leaf's child(null)
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();// backtrack to upper level node A
				res.add(node.val); // print A
				cur = node.right; // switch to A's right leaf
			}
		}
		return res;
	}
	
	//Morris iteration without stack o(1)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();        
        TreeNode pre=null;
        while(root!=null){
            if(root.left==null){   //if root has no left
                res.add(root.val);
                root=root.right;
            }else{                //if root has left, traverse to find the pre-node of the current node and link it to the current node.
                pre=root.left; 
                while(pre.right!=null&&pre.right!=root){   //find root left child's rightmost child->pre
                    pre=pre.right;
                }
                                        //two circumstances:
                if(pre.right==null){    //1. child's right==null, then child's right->root, root move down to left
                    pre.right=root;
                    root=root.left;
                }else{                  //2. child's right==root, means the left subtree has already been visited,
                    pre.right=null;     //then destroy the link, print root, root move down to right
                    res.add(root.val);
                    root=root.right;
                }
            }
        }
        return res;
    }
     
     

}
