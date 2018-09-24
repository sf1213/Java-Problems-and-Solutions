package BST;

public class Validate_Binary_Search_Tree_98 {
//Divide & Conquer Recursion
  public boolean isValidBST(TreeNode root) {
    return valid(root, null, null);
  }

  private boolean valid(TreeNode node, Integer min, Integer max) {
    if(node == null) {
      return true;
    }
    if(max != null && node.val >= max) {
      return false;
    }
    if(min != null && node.val <= min) {
      return false;
    }

    return valid(node.left, min, node.val) && valid(node.right, node.val, max);
  }

  //Post Order Recursion

  class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
      return valid(root);
    }

    private boolean valid(TreeNode node) {
      if(node == null) {
        return true;
      }

      boolean left = valid(node.left);
      if(pre != null && node.val <= pre.val) {
        return false;
      }
      pre = node;
      // boolean right = valid(node.right);
      return left && valid(node.right);
    }
  }

  //Inorder traversal iteration

  public boolean isValidBST(TreeNode root) {
    if(root == null) {
      return true;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    TreeNode pre = null;
    while(cur!= null || !stack.isEmpty()) {
      while(cur!= null) {
        stack.push(cur);
        cur = cur.left;
      }
      TreeNode node = stack.pop();
      if(pre != null && node.val <= pre.val) {
        return false;
      }
      pre = node;
      cur = node.right;
    }
    return true;
  }

  //Morris

  public boolean isValidBST(TreeNode root) {
    if(root == null) {
      return true;
    }
    TreeNode cur = root;
    TreeNode last = null, pre = null;

    while(cur!= null) {
      if(cur.left == null) {
        if(last !=null && cur.val <= last.val) {
          return false;

        }
        last = cur;
        cur = cur.right;
      }else {
        pre = cur.left;
        while(pre.right != null && pre.right != cur) {
          pre = pre.right;
        }
        if(pre.right == null) {
          pre.right = cur;
          cur = cur.left;
        }else {
          if(last !=null && cur.val <= last.val) {
            return false;
          }
          last = cur;
          pre.right = null;
          cur = cur.right;
        }
      }
    }
    return true;
  }
}
