package BST;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
  //Iteration

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }

    TreeNode cur = root;
    while(((long)p.val - cur.val) * ((long)q.val - cur.val) > 0) { //avoid overflow
      if(p.val - cur.val > 0) {
        cur = cur.right;
      }else {
        cur = cur.left;
      }
    }
    return cur;
  }

  //or

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode cur = root;
    while(cur != null) {
      if(p.val > cur.val && q.val > cur.val) {
        cur = cur.right;
      }else if(p.val < cur.val && q.val < cur.val) {
        cur = cur.left;
      }else {
        return cur;
      }
    }
    return null;
  }

  //Recursion

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    if(p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    }else if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }
}
