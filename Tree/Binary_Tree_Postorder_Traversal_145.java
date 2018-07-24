package LeetCode;

import java.util.LinkedList;

public class Binary_Tree_Postorder_Traversal_145 {
	//recursive
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        helper(res,root);
        return res;
    }
    
    public void helper(List<Integer> res,TreeNode root){
        if(root!=null){
            if(root.left!=null){helper(res,root.left);}            
            if(root.right!=null){helper(res,root.right);}
            res.add(root.val);
        }
    }
    
    //Stack iteration, reverse pre-order
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;
        while(!s.isEmpty()||cur!=null){
            if(cur!=null){
                res.addFirst(cur.val);
                s.push(cur.left);
                cur=cur.right;
            }else{
                cur=s.pop();
            }
        }
        return res;
    }
    
    //Not using list.addFirst, simulates the process of PostOrderTraversal 
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!s.isEmpty()){
            while(cur!=null){    //push all the left
                s.push(cur);
                cur=cur.left;
            }
            //check if top has right child
            TreeNode top=s.peek();
            if(top.right==null){       //if top has no right child, it's safe to pop the top node
                cur=s.pop();
                res.add(cur.val);
                //top can be the left or right child of its upper level
                //if top is the right child, means we have already traversed all children of its upper level, it's safe to go                     //back to the upper level and pop it;
                //if top is the left child, make upper level's right child the current node
                while(!s.isEmpty()&&cur==s.peek().right){    
                    cur=s.pop();
                    res.add(cur.val);
                }
                if(s.isEmpty()) break;
                cur=s.peek().right;
            }else{                    //if top has right child, make it the current node
                cur=top.right;
            }
        }
        return res;
    }
    
    //Not using list.addFirst() in a more concise way
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode pre=null;
        expand(s,root); //push all the left node
        while(!s.isEmpty()){
            TreeNode top=s.peek();
            if(top.right==null||top.right==pre){   //if top has no right child or top's right child has already been visited, it's safe to visit top
                s.pop();
                pre=top;
                res.add(top.val);
            }else{                                 //if top has right child, expand top's right children
                expand(s,top.right);
            }
        }
        return res;
        
    }
    
    private void expand(Stack<TreeNode> s, TreeNode node){  
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    }
    
    
//Another concise iteration
public List<Integer> postorderTraversal(TreeNode root) {      
        LinkedList<Integer> res=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=root,pre=null;
        while(!s.isEmpty()||cur!=null){
            while(cur!=null){ //push all the left
                s.push(cur);
                cur=cur.left;
            }            
            cur=s.peek();
            if(cur.right!=null&&cur.right!=pre){
                cur=cur.right;
            }else{
                pre=s.pop();
                res.add(pre.val);
                cur=null;
            }
        }
        return res;
    }
    
    //Morris
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList<>();
        TreeNode cur=root;
        TreeNode pre=null;
        while(cur!=null){
            if(cur.right==null){
                res.addFirst(cur.val);
                cur=cur.left;
            }else{
                pre=cur.right;
                while(pre.left!=null&&pre.left!=cur){
                    pre=pre.left;
                }
                if(pre.left==null){
                    res.addFirst(cur.val);
                    pre.left=cur;
                    cur=cur.right;
                }else{
                    pre.left=null;
                    cur=cur.left;
                }
                
                
            }
        }
        return res;
        
    }

}
