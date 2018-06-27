package LeetCode;

import java.util.Queue;
import java.util.Stack;

public class Maximum_Depth_of_Binary_Tree_104_1 {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	// DFS-Postorder-recursion

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	// DFS-Preorder-Iteration

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

	// BFS-levelorder-Iteration
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

}
