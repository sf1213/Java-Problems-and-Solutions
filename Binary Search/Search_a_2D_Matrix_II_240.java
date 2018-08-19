package Binary_Search;

public class Search_a_2D_Matrix_II_240 {
	//Search from top right corner, 7ms
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length, col = matrix[0].length;               
        int i = 0, j = col - 1;
        while(j >= 0 && i < row){
            if(target == matrix[i][j]){
                return true;
            }else if(target > matrix[i][j]){
                i++;
            }else{
                j--;
            }
        }
        
        return false;
    }
}
