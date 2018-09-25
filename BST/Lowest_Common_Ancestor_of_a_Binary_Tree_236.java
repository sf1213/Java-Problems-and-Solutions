package BST;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
  //Recursion

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    if(root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if(left == null) { //only find right
      return right;
    }else if(right == null) {  //only find left
      return left;
    }
    return root; //find both left and right
  }

  //Recursion, when one node is in tree, the other is not, return null

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    TreeNode tmp = lca(root, p, q);
    if(tmp == p) {

      return isFind(p, q) == true ? p : null;
    }else if(tmp == q) {
      return isFind(q, p) ==true ? q : null;
    }
    return tmp;
  }

  private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    if(root == p || root == q) {
      return root;
    }
    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if(left == null) {
      return right;
    }else if(right == null) {
      return left;
    }
    return root;
  }
  private boolean isFind(TreeNode node, TreeNode target) {
    if(node == null) {
      return false;
    }
    if(node == target) {
      return true;
    }
    return isFind(node.right, target) || isFind(node.left, target);
  }

  //Iteration

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();// node : node's parent
    stack.push(root);
    map.put(root, null);
    while(!stack.isEmpty() && (!map.containsKey(p) || !map.containsKey(q))) {
      TreeNode node = stack.pop();
      if(node.left != null) {
        stack.push(node.left);
        map.put(node.left, node);
      }
      if(node.right != null) {
        stack.push(node.right);
        map.put(node.right, node);
      }
    }
    if(!map.containsKey(p) || !map.containsKey(q)) { //if p/q is not in tree
      return null;
    }
    Set<TreeNode> parents = new HashSet<>();
    TreeNode cur = p;
    while(cur != null) {
      parents.add(cur);
      cur = map.get(cur);
    }
    cur = q;
    while(!parents.contains(cur)) {
      cur = map.get(cur);
    }
    return cur;
  }
}
