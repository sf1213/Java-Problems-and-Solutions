package LeetCode;

public class Invert_Binary_Tree_226 {
	//DFS recursion
	public TreeNode invertTree(TreeNode root) {
        
        if(root==null){return null;}       
        TreeNode left=root.left;
        TreeNode right=root.right;
        
        root.left=invertTree(right);
        root.right=invertTree(left);
        
        return root;
        
    }
		
	//DFS Stack
    public TreeNode invertTree(TreeNode root) { 
        if(root==null){return null;}
        
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            TreeNode left=node.left;
            node.left=node.right;
            node.right=left;
            
            if(node.left!=null){stack.push(node.left);}
            if(node.right!=null){stack.push(node.right);}
        }
        return root;
    }
	
	//BFS Queue
	    public TreeNode invertTree(TreeNode root) {
	        if(root==null){return null;}
	        
	        Queue<TreeNode> q=new LinkedList<>();
	        q.offer(root);
	        while(!q.isEmpty()){
	            TreeNode node=q.poll();
	            TreeNode left=node.left;
	            node.left=node.right;
	            node.right=left;
	            
	            if(node.left!=null){q.offer(node.left);}
	            if(node.right!=null){q.offer(node.right);}
	        }
	        return root;
	    }
	

}
