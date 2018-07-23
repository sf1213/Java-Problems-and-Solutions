package Tree;

public class Symmetric_Tree_101 {
	//recursion 8ms
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }    
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null||right==null) return left==right;
        if(left.val!=right.val) return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
    
  //iteration 9ms
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode cur1=stack.pop();
            TreeNode cur2=stack.pop();
            if(cur1==null&&cur2==null) {
                continue;
            }else if(cur1==null||cur2==null||cur1.val!=cur2.val){
                return false;
            }
            stack.push(cur1.right);
            stack.push(cur2.left);
            stack.push(cur1.left);
            stack.push(cur2.right);
        }
        return true;
    }
}
