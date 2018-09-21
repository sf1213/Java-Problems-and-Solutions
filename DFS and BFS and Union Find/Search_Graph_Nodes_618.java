package DFS_BFS;

public class Search_Graph_Nodes_618 {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
            Map<UndirectedGraphNode, Integer> values,
            UndirectedGraphNode node,
            int target) {
			Queue<UndirectedGraphNode> que = new ArrayDeque<>();
			Set<Integer> set = new HashSet<>();
			que.offer(node);
				if(values.get(node) == target) {
					return node;
				}		
			while(!que.isEmpty()) {
				UndirectedGraphNode cur = que.poll();
				for(UndirectedGraphNode neigh : cur.neighbors) {
					if(values.get(neigh) == target) {
						return neigh;
					}
			
					if(!set.contains(neigh.label)) {
						que.offer(neigh);
						set.add(neigh.label);
					}			
				}
			}
			return null;
		}
	}
}
