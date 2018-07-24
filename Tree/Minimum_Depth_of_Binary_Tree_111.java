package Tree;

public class Minimum_Depth_of_Binary_Tree_111 {
	//Recursion, Post-order or Pre-order, 0ms
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return 1+minDepth(root.right);
        if(root.right==null) return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
	
	//Iteration, Pre-order, Two stack, 3ms
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
       Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<Integer> value=new ArrayDeque<>();
        int minDepth=Integer.MAX_VALUE,height=0;
        stack.push(root);
        value.push(1);
        TreeNode cur=null;
        while(!stack.isEmpty()){
            cur=stack.pop();
            height=value.pop();
            if(cur.left==null&&cur.right==null){
                minDepth=Math.min(minDepth,height);
                continue;
            }
            if(cur.right!=null){
                stack.push(cur.right);
                value.push(height+1);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                value.push(height+1);
            }
            
        }
        return minDepth;
    }
	
	//Iteration, Level-order, BFS, One queue, 0ms
	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que=new LinkedList<>();
        int depth=1,size=0;
        que.offer(root);
        TreeNode cur=null;
        while(!que.isEmpty()){
            size=que.size();           
            while(size-->0){
                cur=que.poll(); //poll size times
                if(cur.left==null&&cur.right==null) return depth;
                if(cur.left!=null) que.offer(cur.left);
                if(cur.right!=null) que.offer(cur.right);
            }
            depth++;
            
        }
        return depth;
    }
}
