package Tree;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106 {
//DFS recursion

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder == null || inorder.length == 0) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return dfsBuild(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, map);
  }
  private TreeNode dfsBuild(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
    if(inStart > inEnd) {
      return null;
    }
    int value = postorder[postStart];
    int index = map.get(value);
    TreeNode node = new TreeNode(value);
    node.right = dfsBuild(postStart - 1, index + 1, inEnd, inorder, postorder, map);
    node.left = dfsBuild (postStart - (inEnd - index + 1), inStart, index - 1, inorder, postorder, map);
    return node;
  }

  //Stack iteration

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(postorder == null || postorder.length == 0) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    TreeNode root = new TreeNode(postorder[postorder.length - 1]);
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    for(int i = postorder.length - 2; i >= 0; i--) {
      int value = postorder[i];
      TreeNode node = new TreeNode(value);
      if(map.get(value) > map.get(stack.peek().val)) {
        stack.peek().right = node;
      }else {
        TreeNode parent = null;
        while(!stack.isEmpty() && map.get(value) < map.get(stack.peek().val)) {
          parent = stack.pop();
        }
        parent.left = node;
      }
      stack.push(node);
    }
    return root;
  }

}
