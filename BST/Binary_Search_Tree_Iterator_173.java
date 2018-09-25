package BST;

public class Binary_Search_Tree_Iterator_173 {
  //Stack Iteration

  public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
      stack = new ArrayDeque<>();
      this.cur = root;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !stack.isEmpty() || cur != null;
    }
    /** @return the next smallest number */
    public int next() {
      while(cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      TreeNode res = stack.pop();
      cur = res.right;
      return res.val;
    }
  }

  //Morris

  public class BSTIterator {
    TreeNode cur;
    public BSTIterator(TreeNode root) {
      this.cur = root;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return cur != null;
    }
    /** @return the next smallest number */
    public int next() {
      int res = 0;
      TreeNode pre = null;
      while(hasNext()) {
        if(cur.left == null) {
          res = cur.val;
          cur = cur.right;
          break;
        }else {
          pre = cur.left;
          while(pre.right != null && pre.right != cur) {
            pre = pre.right;
          }
          if(pre.right == null) {
            pre.right = cur;
            cur = cur.left;
          }else {
            res = cur.val;
            pre.right = null;
            cur = cur.right;
            break;
          }
        }
      }
      return res;
    }
  }
}
