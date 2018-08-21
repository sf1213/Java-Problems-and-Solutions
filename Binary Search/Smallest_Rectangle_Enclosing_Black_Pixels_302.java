package Binary_Search;

public class Smallest_Rectangle_Enclosing_Black_Pixels_302 {
	//DFS, may cause stack overflow
	private int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MAX_VALUE, bottom = Integer.MIN_VALUE;
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return -1;
        }       
        dfs(image, x, y);       
        return (right - left + 1) * (bottom - top + 1);
    }   
    private void dfs(char[][] image, int x, int y){
        int row = image.length, col = image[0].length;
        if(x < 0 || x >=row || y < 0 || y >=col || image[x][y] == '0'){
            return;
        }
        
        left = Math.min(left, y);
        right = Math.max(right, y);
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        
        image[x][y] = '0'; //visited
        
        dfs(image, x + 1, y); //down
        dfs(image, x - 1, y); //up
        dfs(image, x, y + 1); //right
        dfs(image, x, y - 1); //left
    }
    
    //BFS, may cause space overflow
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return -1;
        }
        
        int left = y, right = y, top = x, bottom = x;
        int row = image.length, col = image[0].length;
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(x * col + y);
        image[x][y] = '0'; //visited
        
        while(!que.isEmpty()){
            for(int k = 0; k < que.size(); k++){
                int cell = que.poll();
                int i = cell / col, j = cell % col;
                   
                left = Math.min(left, j);
                right = Math.max(right, j);
                top = Math.min(top, i);
                bottom = Math.max(bottom, i);
                
                image[i][j] = '0'; //visited
                
                if(i < row - 1 && image[i + 1][j] == '1'){ //down
                    que.offer((i + 1) * col + j);
                    image[i + 1][j] = '0';
                }
                if(i > 0 && image[i - 1][j] == '1'){ //up
                    que.offer((i - 1) * col + j);
                    image[i - 1][j] = '0';
                }
                if(j < col - 1 && image[i][j + 1] == '1'){ //right
                    que.offer(i * col + j + 1);
                    image[x][y + 1] = '0';
                }
                if(j > 0 && image[i][j - 1] == '1'){ //left
                    que.offer(i * col + j - 1);
                    image[i][j - 1] = '0';
                }
            }
            
        }
        
        return (right - left + 1) * (bottom - top + 1);
     
    }
	
	//Binary Search, 428ms
	public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return -1;
        }
        
        int row = image.length;
        int col = image[0].length;
        
        int leftBound = find1(image, 0, row, 0, y, true, true); //find leftmost 1
        int rightBound = find1(image, 0, row, y + 1, col, true, false); //find leftmost 0, right = col多一位
        int upBound = find1(image, leftBound, rightBound, 0, x, false, true); //find upmost 1
        int bottomBound = find1(image, leftBound, rightBound, x + 1, row, false, false); //find upmost 0， right = row多一位
        
        return (rightBound - leftBound) * (bottomBound - upBound);
    }
    
    private int find1(char[][]image, int start, int end, int left, int right, boolean horizon, boolean search1){
        
        while(left < right){
            int mid = left + (right - left) / 2;
            boolean hasTarget = false;
            for(int i = start; i < end; i++){
                if((horizon ? image[i][mid] : image[mid][i]) == '1'){
                    hasTarget = true;
                    break;
                }
            }
            
            if(hasTarget == search1){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}
