package Tree;

public class Binary_Tree_Maximum_Path_Sum_124 {
	
	//Recursion 1, global variable MaxValue, 1ms
	int MaxValue; //global variable 
    public int maxPathSum(TreeNode root) {
        MaxValue=Integer.MIN_VALUE;
        helper(root);
        return MaxValue;
    }
    
    private int helper(TreeNode root){
        if(root==null) return 0;
        //when left/right is negative, set it to 0,prune the negative node
        //meaning MaxRoute start don't start from negative
        int hLeft=Math.max(0,helper(root.left));
        int hRight=Math.max(0,helper(root.right));
        MaxValue=Math.max(MaxValue, hLeft+hRight+root.val);
        return Math.max(hLeft+root.val,hRight+root.val);
    }
    
    //Recursion 2, int[] MaxValue, 1ms
    public int maxPathSum(TreeNode root) {
        int[] maxValue=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        helper(root,maxValue);
        return maxValue[0];
    }
    
    private int helper(TreeNode root,int[] maxValue){
        if(root==null) return 0;
        //when left/right is negative, set it to 0
        //meaning MaxRoute don't start from negative
        int hLeft=Math.max(0,helper(root.left,maxValue));
        int hRight=Math.max(0,helper(root.right,maxValue));
        maxValue[0]=Math.max(maxValue[0], hLeft+hRight+root.val);
        return Math.max(hLeft+root.val,hRight+root.val);
    }
    
    //Iteration, Post-order, One stack, 18ms
    public int maxPathSum(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Map<TreeNode,Integer> map=new HashMap<>(); //record node's path sum
        TreeNode cur=root,pre=null;
        int maxValue=Integer.MIN_VALUE;
        int hleft=0,hright=0;
        map.put(null,0); // for simplicity we want to handle null nodes
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.right!=null&&cur.right!=pre){
                cur=cur.right;
            }else{
                pre=stack.pop();
                hleft=Math.max(0,map.get(pre.left));
                hright=Math.max(0,map.get(pre.right));
                if(hright<0) hright=0;
                maxValue=Math.max(maxValue,hleft+hright+pre.val);
                map.put(pre,Math.max(pre.val+hleft,pre.val+hright));
                cur=null;                
            }
        }
        return maxValue;
    }
}
