package Tree;

public class Count_Complete_Tree_Nodes_222 {
	//Recursion,  just going left,  71ms
	public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        if(lh==rh){ //incomplete tree is on the right side,left side is lh level complete tree
            return (1<<lh)+countNodes(root.right); //(2^h)-1+1+countNodes(right)
        }else{  ////incomplete tree is on the left side,right side is rh(lh-1) level complete tree
            return (1<<rh)+countNodes(root.left);
        }
    }
    private int height(TreeNode root){ //calculate leftmost path's height
        if(root==null) return 0;
        return 1+height(root.left);
    }
    
    //Iteration 41ms
    public int countNodes(TreeNode root) {
        int count=0;
        TreeNode cur=root;
        while(cur!=null){
            int lh=height(cur.left); //left-subtree height
            int rh=height(cur.right); //right-subtree height
            if(lh==rh){   //left tree is complete, right tree is not
                count+=1<<lh;   //left-subtree number+root
                cur=cur.right;  //move to right-subtree
            }else{     //right tree is complete, left tree is not
                count+=1<<rh;
                cur=cur.left;
            }
        }
        return count;
    }
    private int height(TreeNode root){ //calculate leftmost path's height
        if(root==null) return 0;
        int h=0;
        while(root!=null){
            root=root.left;
            h++;
        }
        return h;
    }
}
