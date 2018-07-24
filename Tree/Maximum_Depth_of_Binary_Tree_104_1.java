package LeetCode;

import java.util.Queue;
import java.util.Stack;

public class Maximum_Depth_of_Binary_Tree_104_1 {

	// DFS-Postorder-recursion

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// DFS-Preorder-Iteration Two Stack

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		int max = 0;

		stack.push(root);
		value.push(1);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(temp, max);
			if (node.right != null) {
				stack.push(node.right); // push right first to realize Preorder(node-left-right)
				value.push(temp + 1);
			}

			if (node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}

		}
		return max;
	}

	// BFS-levelorder-Iteration One queue
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}
			depth++;
		}
		return depth;
	}

	
//Iteration, Post-order, One stack
public int maxDepth(TreeNode root) {
        if(root==null){return 0;}
        int depth=0,maxHeight=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root, pre=null;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                depth++;
                cur=cur.left;
            }
           cur=stack.peek();            
            if(cur.right!=null&&cur.right!=pre){
                cur=cur.right;
            }else{
                if(cur.left==null&&cur.right==null){
                    maxHeight=Math.max(maxHeight,depth);
                 }
                pre=stack.pop();
                depth--;
                cur=null;
            }
        }        
        return maxHeight;
    }
	
}
