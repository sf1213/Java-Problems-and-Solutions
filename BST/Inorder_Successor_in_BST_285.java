package BST;

public class Inorder_Successor_in_BST_285 {
  //Iteration

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null) {
      return null;
    }
    TreeNode cur = root;
    TreeNode next = null;
    while(cur != null) {
      if(cur == p) {
        break;
      }else if (p.val < cur.val) {
        next = cur;
        cur = cur.left; //go samll
      }else {  //can handle duplicate here
        cur = cur.right; //go big
      }
    }
    if(cur == null) { //not found
      return null;
    }
    if(cur.right == null) {
      return next;
    }
    cur = cur.right;
    while(cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }

  //More Concise  but can’t handle situations 1. node p not in tree, 2. duplicate

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null) {
      return null;
    }
    TreeNode cur = root;
    TreeNode next = null;
    while(cur != null) {
      if(p.val < cur.val) {
        next = cur;
        cur = cur.left;//go small
      }else {
        cur = cur.right; //go big
      }
    }
    return next;
  }

  //Recursion

  class Solution {
    TreeNode pre = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      find(root, p);
      return pre;
    }
    private void find(TreeNode node, TreeNode p) {
      if(node == null) {
        return;
      }
      if(node.val > p.val) {
        pre = node;
        find(node.left, p); //go small
      }else {
        find(node.right, p); //go big
      }
    }
  }


}
