package Tree;

public class Flatten_Binary_Tree_to_Linked_List_114 {
	//Recursion, Post-Order(right->left->root) 9ms
    public void flatten(TreeNode root) {
        subFlatten(root,null);
    }
    private TreeNode subFlatten(TreeNode root,TreeNode pre){
        if(root==null) return pre;
        pre=subFlatten(root.right,pre);
        pre=subFlatten(root.left,pre);
        root.right=pre;
        root.left=null;
        pre=root;
        return pre;
    }
    
  //Iteration, Like Morris 13ms
    public void flatten(TreeNode root) {
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
            //find left child's rightmost child
            TreeNode pre=cur.left;
            while(pre.right!=null){
                pre=pre.right;
            }
            pre.right=cur.right;
            cur.right=cur.left;
            cur.left=null;
            }
            cur=cur.right;
        }        
    }
}
