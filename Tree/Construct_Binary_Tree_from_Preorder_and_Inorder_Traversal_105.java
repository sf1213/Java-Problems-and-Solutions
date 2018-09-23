package Tree;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
  //DFS recursion

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return dfsBuild(0, 0, inorder.length - 1, preorder, inorder, map);
  }
  private TreeNode dfsBuild(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
    if(inStart > inEnd) {
      return null;
    }
    int value = preorder[preStart];
    TreeNode root = new TreeNode(value);

    int index = map.get(value); //O(1)
    // for(int i = inStart; i <=inEnd; i++) { //O(n)
    //     if(inorder[i] == root.val) {
    //         index = i;
    //         break;
    //     }
    // }
    root.left = dfsBuild(preStart + 1, inStart, index - 1, preorder, inorder, map);
    root.right = dfsBuild(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder, map);
    return root;
  }

  //Stack iteration

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder == null || preorder.length == 0) {
      return null;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    for(int i = 1; i < preorder.length; i++) {
      int value = preorder[i];
      TreeNode newNode = new TreeNode(value);
      if(map.get(value) < map.get(stack.peek().val)) {
        stack.peek().left = newNode; //left of the last node in stack
      }else { //right of the last node in stack
        TreeNode parent = null;
        //1. newNode is the right child of current node (last node in stack)
        //2. newNode is the right child of current node'ancestors
        while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
          parent = stack.pop();
        }
        parent.right = newNode;
      }
      stack.push(newNode);
    }
    return root;
  }


}
