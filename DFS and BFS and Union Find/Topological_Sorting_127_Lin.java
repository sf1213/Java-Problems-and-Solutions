package DFS_BFS;
/**
* Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Topological_Sorting_127_Lin {
		//BFS
	    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
	        ArrayList<DirectedGraphNode> res = new ArrayList<>();
	        if(graph == null || graph.size() == 0) {
	            return res;
	        }
	        
	        Map <DirectedGraphNode, Integer> map = new HashMap<>();
	        for(DirectedGraphNode node : graph) { //count all neighbors in map
	            for(DirectedGraphNode neighbor : node.neighbors){
	                map.put(neighbor, map.getOrDefault(neighbor,0) + 1);
	            }
	        }
	        
	        Queue<DirectedGraphNode> que = new LinkedList<>();
	        for(DirectedGraphNode node : graph) { //put nodes with indgree 0 in queue
	            if(!map.containsKey(node)){
	                que.offer(node);
	                res.add(node);
	            }
	        }
	        
	        while(!que.isEmpty()){  //BFS
	            DirectedGraphNode cur = que.poll();
	            for(DirectedGraphNode neigh : cur.neighbors) {
	                int num = map.get(neigh);
	                map.put(neigh, num - 1);
	                
	                if(num - 1 == 0) {
	                    que.offer(neigh);
	                    res.add(neigh);
	                }
	            }
	        }	        
	        return res;
	    }
	
	    //DFS
	    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
	        if(graph == null || graph.size() == 0) {
	            return new ArrayList<>();
	        }
	        
	       LinkedList<DirectedGraphNode> res = new LinkedList<>();    
	       Set<DirectedGraphNode> gray = new HashSet<>(); //Mark the current route to this node
	       Set<DirectedGraphNode> black = new HashSet<>(); //mark visited node permanently
	       
	       for(DirectedGraphNode node : graph) {
	           if(!gray.contains(node) && !black.contains(node)) {
	               dfs(res, gray, black, node);
	           }
	       }
	       return new ArrayList<>(res);
	    }
	    
	    private void dfs(LinkedList <DirectedGraphNode> res, Set<DirectedGraphNode> gray, Set<DirectedGraphNode> black, DirectedGraphNode node) {
	        //If node has been marked grey, then graph is not DAG!
	    	gray.add(node);
	        for(DirectedGraphNode neighbor : node.neighbors) {
	            if(!gray.contains(neighbor) && !black.contains(neighbor)){
	                dfs(res, gray, black, neighbor);
	            }
	        }
	        black.add(node);
	        gray.remove(node);
	        res.addFirst(node);
	    }
}
