package BST;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {
  //Recursion

  public TreeNode sortedListToBST(ListNode head) {
    return build(head, null);
  }
  private TreeNode build(ListNode head, ListNode tail) {
    if(head == tail) {
      return null;
    }
    ListNode slow = head, fast = head;
    while(fast != tail && fast.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }
    TreeNode node = new TreeNode(slow.val);
    node.left = build(head, slow);
    node.right = build(slow.next, tail);
    return node;
  }

  //Inorder recursion

  class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
      if(head == null) {
        return null;
      }
      ListNode cur = head;
      int size = 0;
      while(cur != null) {
        size++;
        cur = cur.next;
      }
      node = head;
      return inorder(0, size - 1);
    }
    private TreeNode inorder(int start, int end) {
      if(start > end) {
        return null;
      }
      int mid = start + (end - start) / 2;
      TreeNode left = inorder(start, mid - 1);
      TreeNode cur = new TreeNode(node.val);
      node = node.next;
      cur.left = left;

      TreeNode right = inorder(mid + 1, end);
      cur.right = right;
      return cur;
    }
}
