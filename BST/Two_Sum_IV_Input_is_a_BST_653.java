package BST;

public class Two_Sum_IV_Input_is_a_BST_653 {
  //DFS + HashSet

  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return isFind(root, set, k);
  }
  private boolean isFind(TreeNode node, Set<Integer> set, int k) {
    if(node == null) {
      return false;
    }
    if(set.contains(k - node.val)) {
      return true;
    }
    set.add(node.val);
    return isFind(node.left, set, k) || isFind(node.right, set, k);
  }

  //Inorder + List + Two Pointers

  public boolean findTarget(TreeNode root, int k) {
    if(root == null) {
      return false;
    }
    List<Integer> res = new ArrayList<>();
    inorder(root, res);
    int left = 0, right = res.size() - 1;
    while(left < right) {
      if(res.get(left) + res.get(right) == k) {
        return true;
      }else if(res.get(left) + res.get(right) < k) {
        left++;
      }else {
        right--;
      }
    }
    return false;
  }
  private void inorder(TreeNode root, List<Integer> res) {
    if(root == null) {
      return;
    }
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }

  //BST Iterater + Two Pointers

  public boolean findTarget(TreeNode root, int k) {
    if(root == null) {
      return false;
    }
    BstIterator forward = new BstIterator(root, true);
    BstIterator backward = new BstIterator(root, false);

    TreeNode left = forward.next();
    System.out.println(left.val);
    TreeNode right = backward.next();
    System.out.println(right.val);
    while(left != right) {
      if(left.val + right.val == k) {
        return true;
      }else if(left.val + right.val < k) {
        left = forward.next();
      }else{
        right = backward.next();
      }
    }
    return false;
  }
}
class BstIterator{
  Deque<TreeNode> stack;
  TreeNode cur;
  boolean isForward;
  public BstIterator(TreeNode root, boolean isForward) {
    this.stack = new ArrayDeque<>();
    this.cur = root;
    this.isForward = isForward;
  }

  public boolean hasNext(){
    return !stack.isEmpty() || cur != null;
  }

  public TreeNode next(){
    while(cur != null) {
      stack.push(cur);
      cur = isForward ? cur.left : cur.right;
    }

    TreeNode res = stack.pop();
    cur = isForward ? res.right : res.left;
    return res;
  }

  //pre() next() + Two Pointers

  public boolean findTarget(TreeNode root, int k) {
    if(root == null) {
      return false;
    }
    TreeNode left = minNode(root);
    TreeNode right = maxNode(root);
    while(left != right) {
      if(left.val + right.val == k) {
        return true;
      }else if(left.val + right.val < k) {
        left = next(root, left);
      }else {
        right = pre(root, right);
      }
    }
    return false;
  }
  private TreeNode minNode(TreeNode root) {
    TreeNode res = root;
    while (res.left!= null) {
      res = res.left;
    }
    return res;
  }
  private TreeNode maxNode(TreeNode root) {
    TreeNode res = root;
    while (res.right!= null) {
      res = res.right;
    }
    return res;
  }
  private TreeNode pre(TreeNode root, TreeNode target) {
    TreeNode pre = null;
    TreeNode cur = root;
    while(cur != null) {
      if(cur.val == target.val) {
        break;
      }else if(target.val > cur.val) {
        pre = cur;
        cur = cur.right;
      }else {
        cur = cur.left;
      }
    }
    if(cur == null) { //not found
      return null;
    }
    if(cur.left == null) {
      return pre;
    }
    cur = cur.left;
    while(cur.right != null) {
      cur = cur.right;
    }
    return cur;
  }
  private TreeNode next(TreeNode root, TreeNode target) {
    TreeNode next = null;
    TreeNode cur = root;
    while(cur != null) {
      if(cur.val == target.val) {
        break;
      }else if(target.val < cur.val) {
        next = cur;
        cur = cur.left;
      }else {
        cur = cur.right;
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
}
