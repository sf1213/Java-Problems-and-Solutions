package Tree;

public class Balanced_Binary_Tree_110 {
	//Recursion 1, top-down
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int hLeft=height(root.left);
        int hRight=height(root.right);
        return Math.abs(hLeft-hRight)<=1&&isBalanced(root.left)&&isBalanced(root.right);
        
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    
    //Recursion 2, -1
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
        
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int hLeft=height(root.left);
        if(hLeft==-1) return -1;
        int hRight=height(root.right);
        if(hRight==-1) return -1;
        if(Math.abs(hLeft-hRight)>1) return -1;
        else return 1+Math.max(hLeft,hRight);
        
    }
    
  //Iteration, Post-order, 4ms
    public boolean isBalanced(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Map<TreeNode,Integer> map=new HashMap<>();//record node's height
        TreeNode cur=root,pre=null;
        int hLeft=0,hRight=0;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right!=null&&cur.right!=pre){
                cur=cur.right;
            }else{
                pre=stack.pop();
                //get pre's left and right child's height
                hLeft=pre.left==null? 0:map.get(pre.left);
                hRight=pre.right==null?0:map.get(pre.right);
                if(Math.abs(hLeft-hRight)>1) return false;
                else map.put(pre,1+Math.max(hLeft,hRight));
                cur=null;
            }
        }
    return true;
    }
}
