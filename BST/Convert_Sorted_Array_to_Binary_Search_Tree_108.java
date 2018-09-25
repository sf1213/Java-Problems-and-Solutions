package BST;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
  //Recursion

  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
  }
  private TreeNode build(int[] nums, int start, int end) {
    if(start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = build(nums, start, mid - 1);
    node.right = build(nums, mid + 1, end);
    return node;
  }

  //BFS iteration

  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) {
      return null;
    }
    Queue<MyNode> que = new ArrayDeque<>();
    int mid = (nums.length - 1) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    que.offer(new MyNode(root, 0, nums.length - 1));
    while(!que.isEmpty()) {
      MyNode cur = que.poll();
      mid = cur.left + (cur.right - cur.left) / 2;
      if(mid != cur.left) {
        TreeNode left = new TreeNode(nums[cur.left + (mid - 1 - cur.left) / 2]);
        cur.node.left = left;
        que.offer(new MyNode(left, cur.left, mid - 1));
      }
      if(mid != cur.right) {
        TreeNode right = new TreeNode(nums[mid + 1 + (cur.right - mid - 1) / 2]);
        cur.node.right = right;
        que.offer(new MyNode(right,mid + 1, cur.right));
      }
    }
    return root;
  }
}
class MyNode{
  TreeNode node;
  int left;
  int right;
  public MyNode(TreeNode node, int left, int right) {
    this.node = node;
    this.left = left;
    this.right = right;
  }
}
