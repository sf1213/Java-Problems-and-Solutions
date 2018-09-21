package DFS_BFS;

public class Surrounded_Regions_130 {
	//DFS recursion, direction matrix, 4ms
	public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        if(m==1&&n==1&&board[0][0]=='O') return;
        int[][]dir={{0,1},{1,0},{0,-1},{-1,0}}; //direction
        int[]step={n-1,m-1};   //# of loops for each direction
        int a=0,x=0,y=0;      //a=0:horizon; a=1:vertical
        for(int i=0;i<4;i++){   //walk through four edges
            for(int j=0;j<step[a%2];j++){
                x+=dir[i][0];
                y+=dir[i][1];
                if(board[x][y]=='O'){
                    dfsMark(board,x,y);
                }
            }
            a++;
        }
        //set all 'O' to 'X', all '1' back to 'O'
        for(int i=0;i<m;i++){ 
            for(int j=0;j<n;j++){
            	board[i][j]= (board[i][j]=='1')? 'O':'X';
            }
        }
        
    }
    //Set connect edge 'O' to '1'
    private void dfsMark(char[][]board,int i,int j){ 
        if(board[i][j]!='O') return;
        board[i][j]='1';
        int m=board.length;
        int n=board[0].length;
        if(i<m-1) dfsMark(board,i+1,j);
        if(i>0) dfsMark(board,i-1,j);
        if(j<n-1) dfsMark(board,i,j+1);
        if(j>0) dfsMark(board,i,j-1);
    }
    
    ///DFS recursion 2, 4ms
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        for(int i=0;i<m;i++){ //vertical boundary
            dfsMark(board,i,0);
            if(n>1) dfsMark(board,i,n-1);
        }
         for(int j=1;j<n-1;j++){ //horizon boundary, j from 1 to n-2
            dfsMark(board,0,j);
            if(m>1) dfsMark(board,m-1,j);
        }
        //set all 'O' to 'X', all '1' back to 'O'
        for(int i=0;i<m;i++){ 
            for(int j=0;j<n;j++){
            	board[i][j]= (board[i][j]=='1')? 'O':'X';
            }
        }
        
    }
    //Set connect edge 'O' to '1'
    private void dfsMark(char[][]board,int i,int j){ 
        if(board[i][j]!='O') return;
        board[i][j]='1';
        int m=board.length;
        int n=board[0].length;
        if(i<m-1) dfsMark(board,i+1,j);
        if(i>0) dfsMark(board,i-1,j);
        if(j<n-1) dfsMark(board,i,j+1);
        if(j>0) dfsMark(board,i,j-1);
    }
    
    //BFS, Queue, 5ms
    public void solve(char[][] board) {
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        for(int i=0;i<m;i++){ //vertical boundary
            bfsBoundry(board,i,0);
            if(n>1) bfsBoundry(board,i,n-1);
        }
        for(int j=1;j<n-1;j++){ //horizon boundary, j from 1 to n-2
            bfsBoundry(board,0,j);
            if(m>1) bfsBoundry(board,m-1,j);
        }       
        for(int i=0;i<m;i++){   //set all 'O' to 'X', all '1' back to 'O'
            for(int j=0;j<n;j++){  
               board[i][j]= (board[i][j]=='1')? 'O':'X';
            }
        }
        
    }
    //Set connect edge 'O' to '1'
    private void bfsBoundry(char[][]board,int i,int j){ 
        if(board[i][j]!='O') return;
        board[i][j]='1';
        Deque<Integer> que=new ArrayDeque<>();
        int row=board.length;
        int col=board[0].length;
        que.offer(i*col+j);
        while(!que.isEmpty()){
            int cell=que.poll();

            int x=cell/col, y=cell%col;
            if(x<row-1&&board[x+1][y]=='O'){
                que.offer((x+1)*col+y);
                board[x+1][y]='1';
            }
            if(x>0&&board[x-1][y]=='O'){
                que.offer((x-1)*col+y);
                board[x-1][y]='1';
            }
            if(y<col-1&&board[x][y+1]=='O'){
                que.offer(x*col+y+1);
                board[x][y+1]='1';
            }
             if(y>0&&board[x][y-1]=='O'){
                que.offer(x*col+y-1);
                board[x][y-1]='1';
            }
            
        }
    }
}
