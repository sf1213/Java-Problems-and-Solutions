package DFS_BFS;

public class Graph_Valid_Tree_261 {
	//BFS

public boolean validTree(int n, int[][] edges) {
     if(n == 0 || edges == null) {
        return false;
    }
    
    if(edges.length != n -1) { //valid tree have n nodes n-1 edges
        return false;
    }
    
    //next, we check if there is any cycle by counting nodes' number
    Map<Integer, Set<Integer>> neighbors = new HashMap<>();
    for(int i = 0; i < n; i++) {
        neighbors.put(i, new HashSet<>());
    }    
    for(int[] pair : edges) {
        neighbors.get(pair[0]).add(pair[1]);
        neighbors.get(pair[1]).add(pair[0]);
    }   
    Queue<Integer> que = new ArrayDeque<>();
    boolean[] visited = new boolean[n];
    que.offer(0);
    visited[0] = true;    
    int count = 1;
    while(!que.isEmpty()) {
        int node = que.poll();
        for(int neigh : neighbors.get(node)) {
            if(visited[neigh]) {
                continue;
            }           
            que.offer(neigh);
            visited[neigh] = true;
            count++;
        }
    }
    return count == n;    
}
}	

//DFS

public boolean validTree(int n, int[][] edges) {
    if(n == 0 || edges == null) {
        return false;
    }      
    if(edges.length != n -1) {
            return false;
        }
    //Map<Integer, Set<Integer>> neighbors = new HashMap<>();
    List<List<Integer>> neighbors = new ArrayList<>();
    for(int i = 0; i < n; i++) { //initialize
        //neighbors.put(i, new HashSet<>());
        neighbors.add(i,new ArrayList<>());
    }    
    for(int[] pair : edges) {
        neighbors.get(pair[0]).add(pair[1]);
        neighbors.get(pair[1]).add(pair[0]);
    }
    Set<Integer> visited = new HashSet<>();     
    //make sure there's no cycle
    if(!isValid(neighbors, visited, 0,-1)){
        return false;
    }   
    //make sure all notes has been visited
    return visited.size() == n;        
}

private boolean isValid(List<List<Integer>> neighbors, Set<Integer> visited, int node, int parent) {
    if(visited.contains(node)) {
        return false;
    }      
    visited.add(node);
    for(int neigh : neighbors.get(node)) {
        //neighbors.get(neigh).remove(node);
        if(neigh == parent) {
            continue;
        }
        if(!isValid(neighbors, visited, neigh, node)) {
            return false;
        }
    }
    return true;
}

//Union-Find with path compression and union by rank

public boolean validTree(int n, int[][] edges) {         
    if(n == 0 || edges == null) {
        return false;
    }   
    if(edges.length != n -1) {
        return false;
    }
    UnionFind uf = new UnionFind(n);
    for(int[] edge : edges) {
        int x = edge[0];
        int y = edge[1];
        if(!uf.union(x, y)) { // cycle check
            return false;
        }
    }
    return uf.getCount() == 1; //single tree check
}  

class UnionFind{
    int[] parents;
    int[] ranks;
    int count;
    public UnionFind(int n) {
        parents = new int[n];
        ranks = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            parents[i] = i; //initilly parent is it self
        }
    }
    public int getCount() {
        return count;
    }
    public int find(int x){
        if(parents[x] != x){ //compression
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if(px == py) {
            return false;
        }
        if(ranks[px] < ranks[py]) {
            parents[px] = py;
        }else if(ranks[py] < ranks[px]) {
            parents[py] = px;
        }else { //rank equal
            parents[px] = py;
            ranks[py]++;
        }
        count--;
        return true;
    }
}
