package Matrix;

public class Spiral_Matrix_54 {
//four bound

public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> res=new LinkedList<>();
       if(matrix==null||matrix.length==0) return res;
       int left=0,top=0;
       int down=matrix.length-1;
       int right=matrix[0].length-1;
       while(top<=down&&left<=right){            
            for(int j=left;j<=right;j++){  //to right
                res.add(matrix[top][j]);
           }
            top++;                       
            for(int i=top;i<=down;i++){  //down
                res.add(matrix[i][right]);
           }
            right--;          
           //prevent after rStart++, rStart>rEnd
            for(int j=right;top<=down&&j>=left;j--){//to left  
                res.add(matrix[down][j]);
            }    
            down--;                                             
            //to prevent after cEnd--, cStart>cEnd
            for(int i=down;left<=right&&i>=top;i--){ //up
                res.add(matrix[i][left]);
            }  
            left++;
        }
        return res;
    }

//direction matrix
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res=new LinkedList<>();
   if(matrix==null||matrix.length==0) return res;
   int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};//direction 
   int m=matrix.length; //row
   int n=matrix[0].length;//column
   int[] step={n,m-1};//how many loop for each direction
   int[] pos={0,-1};//initial position
   int a=0; //index of direction[],0:right,1:down,3:left,4:up
   while(step[a%2]!=0){  //step[a%2],0:horizon,1:vertical
       for(int i=0;i<step[a%2];i++){  //for each direction
           pos[0]+=dir[a][0]; //position-i
           pos[1]+=dir[a][1]; //position-j
           res.add(matrix[pos[0]][pos[1]]);
       }
       step[a%2]--;
       a=(a+1)%4;//the next direction
   }       
   return res;
}
}
