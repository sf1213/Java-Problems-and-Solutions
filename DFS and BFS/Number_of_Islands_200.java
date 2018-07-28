package DFS_BFS;

public class Number_of_Islands_200 {
	//Recursion, DFS, 4ms
	public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    mark(grid,i,j);
                    count++;
                }
            }
        }
        return count;       
    }
    private void mark(char[][]grid,int i,int j){
        if(grid[i][j]!='1') return;
        grid[i][j]='0';     //mark visited
        if(i>0)     mark(grid,i-1,j);             //up
        if(i<grid.length-1) mark(grid,i+1,j);     //down
        if(j>0)     mark(grid,i,j-1);             //left
        if(j<grid[0].length-1) mark(grid,i,j+1); //right
    }
    
    //Iteration, BFS, One queue, 6ms
    public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
      
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    mark(grid,i,j);
                    count++;
                }
            }
        }
        return count;       
    }
    private void mark(char[][]grid,int i,int j){
        Deque<int[]> que=new ArrayDeque<>();
        grid[i][j]='0';  //mark visited
        int m=grid.length;
        int n=grid[0].length;
        que.offer(new int[]{i,j});
        while(!que.isEmpty()){
            int[]a=que.pop();
            int x=a[0],y=a[1];
            if(x<m-1 && grid[x+1][y]=='1'){
                que.offer(new int[]{x+1,y});
                grid[x+1][y]='0';
            }      
            if(x>0 && grid[x-1][y]=='1'){
                que.offer(new int[]{x-1,y});
                grid[x-1][y]='0';
            }                
            if(y<n-1 && grid[x][y+1]=='1'){
                que.offer(new int[]{x,y+1});
                grid[x][y+1]='0';
            }                
            if(y>0 && grid[x][y-1]=='1'){
                 que.offer(new int[]{x,y-1});
                grid[x][y-1]='0';
            }               
        }
    }
    
    //Union Find
    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
        UnionFind uf = new UnionFind(grid);  
        int rows = grid.length;  
        int cols = grid[0].length;  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {  
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;  
    }
    class UnionFind {
        int[] father;  
        int m, n;
        int count = 0;
        UnionFind(char[][] grid) {  
            m = grid.length;  
            n = grid[0].length;  
            father = new int[m*n];  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < n; j++) {  
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }  
            }  
        }
        public void union(int node1, int node2) {  
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        public int find (int node) {  
            if (father[node] == node) {  
                return node;
            }
            father[node] = find(father[node]);  
            return father[node];
        }
    }
}
