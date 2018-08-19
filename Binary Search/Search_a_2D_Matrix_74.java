package Binary_Search;

public class Search_a_2D_Matrix_74 {
	//One Binary Search, 6ms
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0, end = row * col - 1;  //may overflow
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            int num = matrix[mid / col][mid % col];
            if(target == num){
                return true;
            }else if(target > num){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return false;
    }
	
	//Two Binary Search, 7ms
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }        
        int row = matrix.length,  col = matrix[0].length;
        if(col == 0){
            return false;
        }
        
        int start = 0, end = row - 1; //Search row
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == matrix[mid][0]){
                return true;
            }else if(target > matrix[mid][0]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int x = (start == 0) ? 0 : start - 1;
        
        start = 0;
        end = col - 1;
        while(start <= end){    //Search col
            int mid = start + (end - start) / 2;
            if(target == matrix[x][mid]){
                return true;
            }else if(target > matrix[x][mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return false;
    }
	
}
