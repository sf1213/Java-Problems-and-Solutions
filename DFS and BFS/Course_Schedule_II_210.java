package DFS_BFS;

public class Course_Schedule_II_210 {
	//BFS
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int count = 0;
        int[] indegree = new int[numCourses]; //indegree
        List<Integer>[] neighbors = new ArrayList[numCourses]; //outdegree
        for(int i = 0; i < numCourses; i++){ //initialize array of list
            neighbors[i] = new ArrayList<>();
        }
        for(int[] pair : prerequisites) { //count indegree and build outdegree
            indegree[pair[0]]++;
            neighbors[pair[1]].add(pair[0]);            
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) { //put indegree 0 to queue
            if(indegree[i] == 0) {
                que.offer(i);
                res[count++] = i;
            }
        }
        
        while(!que.isEmpty()){ //BFS
            int course = que.poll();
            for(int neigh : neighbors[course]) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    que.offer(neigh);
                    res[count++] = neigh;
                }
            }
        }
        return count == numCourses ? res : new int[0];
    }
	
	//DFS
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] neighbors = new ArrayList[numCourses]; //outdegree
        for(int i = 0; i < numCourses; i++){ //initialize array of list
            neighbors[i] = new ArrayList<>();
        }
        for(int[] pair : prerequisites) { //build outdegree
            neighbors[pair[1]].add(pair[0]);            
        }
        
        boolean[] grey = new boolean[numCourses];
        boolean[] black = new boolean[numCourses];
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++) {
            if(!hasOrder(res, neighbors, grey, black, i)) { //cycle
                return new int[0];
            }
        }
        int[] order = new int[numCourses];
        int m = 0;
        for(int num : res) {
            order[m++] = num;
        }
        
        return order;
    }
    
    private boolean hasOrder(LinkedList<Integer> res, List<Integer> [] neighbors, boolean[] grey, boolean[] black, int course) {
        if(grey[course]) { //cycle
            return false;
        }
        if(black[course]) { //visited
            return true;
        }
        
        grey[course] = true;
        for(int neigh : neighbors[course]) {
            if(!hasOrder(res, neighbors, grey, black, neigh)) {
                return false;
            }
        }
        
        grey[course] = false;
        black[course] = true;
        res.addFirst(course);
        return true;
    }
}
