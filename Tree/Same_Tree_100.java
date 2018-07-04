package Tree;

public class Same_Tree_100 {
	//2 Stack, Preorder
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        if(p!=null) s1.push(p);
        if(q!=null) s2.push(q);
  
        while(!s1.isEmpty()&&!s2.isEmpty()){
            TreeNode cur1=s1.pop();
            TreeNode cur2=s2.pop();
            if(cur1.val!=cur2.val) return false;
            
            if(cur1.left!=null) s1.push(cur1.left);
            if(cur2.left!=null) s2.push(cur2.left);
            if(s1.size()!=s2.size()) return false;
            if(cur1.right!=null) s1.push(cur1.right);            
            if(cur2.right!=null) s2.push(cur2.right);
            if(s1.size()!=s2.size()) return false;
        }
        return s1.size()==s2.size();
    }
    //1 Stack or Queue
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1=new Stack<>();       
         s1.push(p);
         s1.push(q);
        while(!s1.isEmpty()){
            TreeNode cur1=s1.pop();
            TreeNode cur2=s1.pop();
            if(cur1==null&&cur2==null){
                continue;
            }else if(cur1==null||cur2==null||cur1.val!=cur2.val){
                return false;
            }
            
            s1.push(cur1.left);
            s1.push(cur2.left);
            
            s1.push(cur1.right);            
            s1.push(cur2.right);
            
        }
        return true;
    }
    
  //recursion
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null) return p==null&&q==null;
        if(p.val!=q.val) return false;
        
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);       
    }
}
