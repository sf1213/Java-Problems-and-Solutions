package Tree;

public class Binary_Tree_Paths_257 {
	//Two Stack Iteration
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        Stack<String> value=new Stack<>();
        stack.push(root);
        value.push("");
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            String path=value.pop();
            if(node.left==null&&node.right==null) {
                res.add(path+node.val);
                continue;
            }
            if(node.right!=null){
                stack.push(node.right);
                value.push(path+node.val+"->");
            }
            if(node.left!=null){
                stack.push(node.left);
                value.push(path+node.val+"->");
            }            
        }
        return res;
    }
	
	//String "+" Recursion  10ms
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode root, String path){
        if(root==null) return;
        
        if(root.left==null&&root.right==null) res.add(path+root.val);
        if(root.left!=null) helper(res,root.left,path+root.val+"->");
        if(root.right!=null) helper(res,root.right,path+root.val+"->");
    }
    
    //Stringbuilder Recursion  15ms
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();   
        StringBuilder path=new StringBuilder();
        helper(res, root, path);
        return res;
    }
    private void helper(List<String> res, TreeNode root, StringBuilder path){
        if(root==null) return;
        int len=path.length();
        path.append(root.val);
        if(root.left==null&&root.right==null) res.add(path.toString());
        path.append("->");
        if(root.left!=null) helper(res,root.left,path);
        if(root.right!=null) helper(res,root.right,path);
        path.setLength(len);
    }
}
