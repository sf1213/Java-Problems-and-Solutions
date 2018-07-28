package Tree;

public class Verify_Preorder_Serialization_of_a_Binary_Tree_331 {
	public boolean isValidSerialization(String preorder) {
        int diff=1;
        String[] str=preorder.split(",");
        for(String node:str){
            diff--;
            if(diff<0) return false;
            if(!node.equals("#")) diff+=2;            
        }
        return diff==0;
    }
	

public boolean isValidSerialization_PostOrder(String postorder) {
        String[] nodes = postorder.split(",");
        int diff = 1;
        for (String node : nodes) {
                diff--;
                if (!node.equals("#")) diff += 2;
                // Post-Order traversal fail criteria
                if (diff > 0) return false;
        }
        return diff == 0;
}
public boolean isValidSerialization_InOrder(String inorder) {
        String[] nodes = inorder.split(",");
        int diff = 1;
        for (String node : nodes) {
                diff--;
                if (!node.equals("#")) diff += 2;
                // In-Order traversal fail criteria
                if (diff > 1) return false;
        }
        return diff == 0;
}
}
