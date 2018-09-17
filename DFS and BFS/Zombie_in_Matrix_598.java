package DFS_BFS;

public class Zombie_in_Matrix_598 {
	public int zombie(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> que= new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};
        
        int people = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    que.offer(i * col + j);
                    visited[i][j] = true;
                }else if(grid[i][j] == 2) {
                    visited[i][j] = true;
                }else{  //people
                    people++;
                }
            }
        }
        
        if(people == 0) { //corner case
            return 0;
        }
        
        int day = 1;
        while(!que.isEmpty()) {
            int len = que.size();
            for(int i = 0; i < len; i++) {
                int node = que.poll();
                int x = node /col, y = node % col;
                for(int m = 0; m < 4; m++) {
                    int newX = x + directionX[m];
                    int newY = y + directionY[m];
                    
                    if(isFound(grid, visited, newX, newY)) {
                        que.offer(newX * col + newY);
                        visited[newX][newY] = true;
                        people--;
                        
                        if(people == 0) {
                            return day;
                        }
                    }
                }
            }
            day++;
        }
        
        
        return - 1;
    }
    
    private boolean isFound(int[][] grid, boolean[][]visited, int x, int y) {
        int row = grid.length, col = grid[0].length;
        if(x < 0 || y < 0 || x >= row || y >= col || visited[x][y]) {
            return false;
        }
        return true;
    }
}
