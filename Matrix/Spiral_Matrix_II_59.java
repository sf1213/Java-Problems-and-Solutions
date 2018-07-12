package Matrix;

public class Spiral_Matrix_II_59 {
//direction matrix
	public int[][] generateMatrix(int n) {       
        int[][] matrix=new int[n][n];
        if(n==0) return matrix;
        int[][]dir={{0,1},{1,0},{0,-1},{-1,0}};//direction
        int[] step={n,n-1};//how many loops for each direction
        int a=0; //direction index
        int num=1;
        int[]pos={0,-1};//initial position
        while(step[a%2]!=0){
            for(int i=0;i<step[a%2];i++){
                pos[0]+=dir[a][0];
                pos[1]+=dir[a][1];
                matrix[pos[0]][pos[1]]=num++;
            }
            step[a%2]--;
            a=(a+1)%4;
        }
        return matrix;
    }
	//four boundaries
	public int[][] generateMatrix(int n) {       
        int[][] matrix=new int[n][n];
        if(n==0) return matrix;//corner case
        int left=0,right=n-1,top=0,bottom=n-1;//boundries
        int num=1;
        while(true){
            //to right
            for(int col=left;col<=right;col++)
                matrix[top][col]=num++;        
            if(++top>bottom) break;
            //down
            for(int row=top;row<=bottom;row++)
                matrix[row][right]=num++;        
            if(--right<left) break;
            //to left
            for(int col=right;col>=left;col--)
                matrix[bottom][col]=num++;        
            if(--bottom<top) break;
            //up
            for(int row=bottom;row>=top;row--)
                matrix[row][left]=num++;        
            if(++left>right) break;     
        }
        return matrix;
    }
	//More concise direction method
	public int[][] generateMatrix(int n) {       
        int[][] matrix=new int[n][n];
        if(n==0) return matrix;//corner case
       int row=0,col=0;//initial position
        int drow=0,dcol=1;//step
        //walk through in spiral way
        for(int num=1;num<=n*n;num++){
            matrix[row][col]=num;
            //if the number ahead is not 0,turn right
            //index%n to keep index<n
            //index+n to prevent negative index
            if(matrix[(row+drow+n)%n][(col+dcol+n)%n]!=0){
                int temp=dcol;
                dcol=-drow;
                drow=temp;
            }
            row+=drow;
            col+=dcol;
        }       
        return matrix;
    }
}
