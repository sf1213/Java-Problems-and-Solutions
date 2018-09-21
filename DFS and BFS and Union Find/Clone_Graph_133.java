package DFS_BFS;

public class Clone_Graph_133 {
	//BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        
        //record if this node has already been cloned, origin node : clone node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        
        Queue<UndirectedGraphNode> que = new ArrayDeque<>();
        que.offer(node);
        
        while(!que.isEmpty()) {
            UndirectedGraphNode cur = que.poll();
            for(UndirectedGraphNode neigh : cur.neighbors) {
                if(!map.containsKey(neigh)) {
                    map.put(neigh, new UndirectedGraphNode(neigh.label));//clone
                    que.offer(neigh);
                }
                map.get(cur).neighbors.add(map.get(neigh));
            }
        }
        return clone;
    }
	
	//DFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }        
        //record if this node has already been cloned, origin node : clone node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        dfs(map, node);
        return map.get(node);
    }
    
    private void dfs(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if(map.containsKey(node)) {
            return;
        }       
        map.put(node, new UndirectedGraphNode(node.label));
        for(UndirectedGraphNode neigh : node.neighbors) {
            dfs(map, neigh);
            map.get(node).neighbors.add(map.get(neigh));
        }
    }
}
