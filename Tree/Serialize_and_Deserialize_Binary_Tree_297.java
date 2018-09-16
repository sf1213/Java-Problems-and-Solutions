package Tree;

public class Serialize_and_Deserialize_Binary_Tree_297 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            if(node == null) {
                sb.append("X,");
            }else{
                sb.append(node.val).append(",");
                que.offer(node.left);
                que.offer(node.right);
            }           
        }
        //remove #,#,#, at tail
        for(int i = sb.length() - 1; i >= 0; i--) {
            if(sb.charAt(i) == '#' || sb.charAt(i) == ',') {
                sb.deleteCharAt(i);
            }else{
                break;
            }
          
        }        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.equals("")) {
            return null;
        }
        String[] str = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        que.offer(root);
        for(int i = 1; i < str.length; i++) {
            TreeNode node = que.poll();
           
            if(!str[i].equals("X")) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.left);
            }
           
            if(!str[++i].equals("X")) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                que.offer(node.right);
            }
            
        }
        return root;
    }
    
    //DFS
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfsSerial(sb, root);
        
        return sb.toString();
    }
    private void dfsSerial(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("X,");
            return;
        }
        
        sb.append(root.val).append(",");
        dfsSerial(sb, root.left);
        dfsSerial(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        Queue<String> que = new ArrayDeque<>(Arrays.asList(data.split(",")));   
        
        return dfsDeseril(que);
    }
    
    private TreeNode dfsDeseril(Queue<String> que) {
        String cur = que.poll();
        if(cur.equals("X")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = dfsDeseril(que);
        node.right = dfsDeseril(que);
        return node;
    }
}
