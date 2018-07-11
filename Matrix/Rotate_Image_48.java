package Matrix;

public class Rotate_Image_48 {
	//Clockwise 1
	public void rotate(int[][] matrix) {
        int l=matrix.length;
        //swap the symmetry 
        for(int i=1;i<l;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }             
        } 
        //left ↔ right
        for(int i=0;i<l;i++){
            for(int j=0;j<l/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][l-j-1];
            matrix[i][l-j-1]=temp;
            }           
        }
    } 
	//Clockwise 2
	public void rotate(int[][] matrix) {
        int l=matrix.length;
        //up ↔ down
        for(int i=0;i<l/2;i++){            
            int[] temp=matrix[i];
            matrix[i]=matrix[l-1-i];
            matrix[l-1-i]=temp;                      
        }
        //swap the symmetry 
        for(int i=1;i<l;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }             
        }        
    }  
	//Anti-clockwise
	public void rotate(int[][] matrix) {
        int l=matrix.length;
        //swap the symmetry 
        for(int i=1;i<l;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }             
        }   
        //up ↔ down
        for(int i=0;i<l/2;i++){            
            int[] temp=matrix[i];
            matrix[i]=matrix[l-1-i];
            matrix[l-1-i]=temp;                      
        }             
    } 
	//One-time rotate
	public void rotate(int[][] matrix) {
        int l=matrix.length;
        //base on 1/4 of the matrix m, rotate
        for(int i=0;i<l/2;i++){
            for(int j=i;j<l-1-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[l-1-j][i];
                matrix[l-1-j][i]=matrix[l-1-i][l-1-j];
                matrix[l-1-i][l-1-j]=matrix[j][l-1-i];
                matrix[j][l-1-i]=temp;
            }             
        }                 
    } 
}
