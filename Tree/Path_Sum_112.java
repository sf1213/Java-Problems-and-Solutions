package Tree;

public class Path_Sum_112 {
	//Iteration, Pre-Order, two stack 3ms
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> value=new Stack<>();
        
        stack.push(root);
        value.push(root.val);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            int l=value.pop();
            if(cur.left==null&&cur.right==null&&l==sum){
                return true;
            }
            if(cur.left!=null){
                stack.push(cur.left);
                value.push(l+cur.left.val);
            }    
            if(cur.right!=null){
                stack.push(cur.right);
                value.push(l+cur.right.val);
            }    
            
        }
        return false;
    }
	
	//Iteration, Post-Order, one stack 3ms
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root, pre=null;
        int l=0;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){ //push all the left node
                stack.push(cur);
                l+=cur.val;
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.left==null&&cur.right==null&&l==sum) return true;
                 //if cur has right child or cur.right hasn't been visited
            if(cur.right!=null&&cur.right!=pre){ 
                cur=cur.right;
                //else cur has no right child or right child has been visited
            }else{
                pre=stack.pop();
                l-=pre.val;
                cur=null;
                
            }
        }
     return false;
    }
	
	
	//recursion 0ms
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;//only for the original root==null
        if(root.left==null&&root.right==null) return root.val==sum;
        //if left part holds, it will not run the right part;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
