package Matrix;

public class Set_Matrix_Zeroes_73 {
	//O(m+n) Space,create row[m] and col[n] to store the "0" rows/columns
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;//corner case
        int m=matrix.length, n=matrix[0].length;
        int[]row=new int[m];//store the "0" rows
        int[]col=new int[n];//store the "0" columns
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){ //if 0,set correspoding row/col=1
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        //loop through row[]
        for(int i=0;i<m;i++){
            if(row[i]==1){
                Arrays.fill(matrix[i],0);
            }
        }
        //loop through col[]
        for(int j=0;j<n;j++){
            if(col[j]==1){
                for(int a=0;a<m;a++){
                    matrix[a][j]=0;
                }
            }
        }
    }
  //improve: 0(1) Space, use the first row/column to store the "0" rows/columns
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;//corner case
        int m=matrix.length, n=matrix[0].length;
        boolean col0=false;//indicate if there is 0 in col0
        //loop from top-down
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0) col0=true;
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0;
            }
        }
        //loop from bottom-up to keep first row/col uneffected
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=1;j--){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;                
            }
            if(col0) matrix[i][0]=0;
        }        
    }
}
