package Tree;

public class House_Robber_III_337 {
	
	public int rob(TreeNode root) {
        int[] res=robSub(root);
        return Math.max(res[0],res[1]);
    }
    //res[0]:include root, res[1]:not include root
    private int[] robSub(TreeNode root){
        int[] res=new int[2];
        if(root==null) return res;
        int[] left=robSub(root.left);
        int[] right=robSub(root.right);
        //include root, root'left and right must be not included
        res[0]=left[1]+right[1]+root.val;
        //not include root, may or may not include root's left and right,find the max
        res[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return res;
        
    }
}
