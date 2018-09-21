package DFS_BFS;

public class Sequence_Reconstruction_605_Lin {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
	       if(org == null || seqs == null ) {
	           return false;
	       }
	       int n = org.length;
	       Map<Integer, Set<Integer>> neighbors = new HashMap<>();
	       Map<Integer, Integer> indegree = new HashMap<>();

	       for(int[] arr : seqs) {
	           for(int j = 0; j < arr.length; j++) {
	               neighbors.putIfAbsent(arr[j],new HashSet<>());
	               indegree.putIfAbsent(arr[j], 0);
	               if(j > 0) {
	                   //avoid duplicate edge: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
	                   if(!neighbors.get(arr[j - 1]).contains(arr[j])) {
	                       neighbors.get(arr[j - 1]).add(arr[j]);
	                       indegree.put(arr[j], indegree.get(arr[j]) + 1);
	                   }
	                   
	               }
	           }
	       }
	       //org = [1], seqs = [[],[]]
	       //[5,3,2,4,1], seqs = [[5,3,2,4],[4,1],[1],[3],[2,4],[1,1000000000]]
	       if(indegree.size() != n) {
	           return false;
	       }

	       Queue<Integer> que = new LinkedList<>();
	       for(int i = 1; i <= n; i++) {
	           if(indegree.get(i) == 0) {
	               que.offer(i);
	           }
	       }
	       
	       int count = 0;
	       while(!que.isEmpty()) {
	           if(que.size() > 1) {
	               return false;
	           }
	           int num = que.poll();
	           if(num != org[count]) {
	               return false;
	           }
	           count++;
	           for(int neigh : neighbors.get(num)) {
	               indegree.put(neigh, indegree.get(neigh) - 1);
	               if(indegree.get(neigh) == 0) {
	                   que.offer(neigh);
	               }
	           }
	       }
	       
	       return count == n;  //org = [1,2,3], seqs = [[1,2]]
	       
	    }
}
