package DFS_BFS;

public class Course_Schedule_207 {
	//BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    int[] indegree = new int[numCourses];
        List<Integer>[] neighbors = new ArrayList[numCourses];
        int count = 0;
        int row = prerequisites.length;
        
        for(int i = 0; i < numCourses; i++){ //initialize array of list
            neighbors[i] = new ArrayList<>(); //Failing to do so will get null pointer exception when .add
        }
        
        for(int i = 0; i < row; i++) { //build graph node's indegree[] and neighbors[]
            indegree[prerequisites[i][0]]++;
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){ //add course with indgree 0 to queue
            if(indegree[i] == 0){
                que.offer(i);
                count++;
            }
        }
        
        while(!que.isEmpty()) {
            int course = que.poll();  
            for(int neigh : neighbors[course]) {
                //int neigh = neighbors[course].get(i);
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    count++;
                    que.offer(neigh);
                }
            }                
        }      
        return count == numCourses;	        
	    }
	
	//DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] neighbors = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){ //initialize array of list
            neighbors[i] = new ArrayList<>(); //Failing to do so will get null pointer exception when .add
        }
        
        for(int i = 0; i < prerequisites.length; i++) { //build graph node's outdegree neighbors[]
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] grey = new boolean[numCourses]; //mark current route to current node
        boolean[] black = new boolean[numCourses];//mark visited node
        for(int i = 0; i < numCourses; i++){
            if(!dfs(neighbors, grey, black, i)) {
                return false;
            }            
        }
        return true;	        
	}
    
    private boolean dfs(List<Integer>[] neighbors, boolean[] grey, boolean[] black, int course) {
        if(grey[course]) { //cycle
            return false;
        }
        if(black[course]) { //visited
            return true;
        }
        grey[course] = true;
        for(int neigh : neighbors[course]){
            //int neigh = neighbors[course].get(i);
            if(!dfs(neighbors, grey, black, neigh)){
                return false;
            }
        }
        grey[course] = false;
        black[course] = true;
        return true;
    }
}
