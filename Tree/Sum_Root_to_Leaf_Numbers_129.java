package Tree;

public class Sum_Root_to_Leaf_Numbers_129 {
//Recursion,Pre-order, DFS  0ms
	public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root,int sum){
        if(root==null) return 0;
        sum=sum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }
        return helper(root.left,sum)+helper(root.right,sum);       
    }
    
  //Iteration, Post-order, 	One stack, 1ms
    public int sumNumbers(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        int total=0,sum=0;
        TreeNode cur=root,pre=null;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){ //push all the left children
                stack.push(cur);
                sum=sum*10+cur.val;
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right!=null&&cur.right!=pre){//cur has right children, and hasn't been visited
                cur=cur.right;
            }else{ //cur has no right childen, or we have just visited it's right children
                if(cur.left==null&&cur.right==null) {
                    total+=sum;
                }
                pre=stack.pop();
                sum/=10;//delete this node's val
                cur=null;
            }
        }
        return total;
    }
    
  //Iteration, Pre-order, Two stack, 1ms
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<Integer> value=new ArrayDeque<>();
        int total=0,sum=0;
        stack.push(root);
        value.push(root.val);
        TreeNode cur=null;
        while(!stack.isEmpty()){
            cur=stack.pop();
            sum=value.pop();
            if(cur.left==null&&cur.right==null) {
                total+=sum;
                continue;
            }
            if(cur.right!=null){
                stack.push(cur.right);
                value.push(sum*10+cur.right.val);
            }
            if(cur.left!=null){
                stack.push(cur.left);
                value.push(sum*10+cur.left.val);
            }
        }
        return total;
    }
    
}
