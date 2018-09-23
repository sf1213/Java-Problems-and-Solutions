package Tree;

public class Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889 {

  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < post.length - 1; i++) {
      map.put(post[i], i);
    }
    return build(0, pre.length - 1, 0, post.length - 1, pre, post, map);
  }

  private TreeNode build(int preStart, int preEnd, int postStart, int postEnd, int[] pre, int[] post, Map<Integer, Integer> map) {
    if(postStart > postEnd) {
      return null;
    }
    TreeNode node = new TreeNode(pre[preStart]);
    if(preStart + 1 > preEnd) {
      return node;
    }
    int nextValue = pre[preStart + 1];
    int index = map.get(nextValue);
    //preStart + 1 node's whole subtree include itself
    int size = index - postStart + 1;
    node.left = build(preStart + 1, preStart + size, postStart, index, pre, post, map);
    node.right = build(preStart + size + 1, preEnd, index + 1, postEnd - 1, pre, post, map);
    return node;
  }

}
