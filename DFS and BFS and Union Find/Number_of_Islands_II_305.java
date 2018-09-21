package DFS_BFS;

public class Number_of_Islands_II_305 {
	//Array, Union-Find with path compression and union by rank
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }  
        
        UnionFind uf = new UnionFind(m * n);
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        //int[][] grid = new int[m][n];
        int count = 0;
        
        for (int[] pos : positions) {
            int node1 = pos[0] * n + pos[1];
            uf.add(node1);
            boolean isUnion = false;
            for (int[] direct : directions) {
                int newX = pos[0] + direct[0];
                int newY = pos[1] + direct[1];
                int node2 = newX * n + newY;
                if (newX < 0 || newY < 0 || newX >= m || newY >= n ||!uf.isValid(node2)) {
                    continue;
                }
                
                uf.union(node1, node2);                     
            }
            res.add(uf.getCount());
        }
        return res;
    }
    
    class UnionFind{
        private int[] parents;
        private int[] ranks;
        private int count;
        
        public UnionFind(int n) {
            count = 0;
            parents = new int[n];
            ranks = new int[n];
            Arrays.fill(parents, -1);
        }
        public int getCount() {
            return count;
        }
        public void add(int x) {
            parents[x] = x;
            count++;
        }
        
        public boolean isValid(int x){
            return parents[x] != -1;
        }
        public int find(int x) {
            if(parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) {
                return;
            }
            if(ranks[px] < ranks[py]) {
                parents[px] = py;
            }else if(ranks[py] < ranks[px]) {
                parents[py] = px;
            }else{
                parents[py] = px;
                ranks[px]++;
            }
            count--;
        }
    }
    
    //HashMap
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }  
        
        UnionFind uf = new UnionFind(m * n);
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        //int[][] grid = new int[m][n];
        int count = 0;
        
        for (int[] pos : positions) {
            int node1 = pos[0] * n + pos[1];
            uf.add(node1);
            boolean isUnion = false;
            for (int[] direct : directions) {
                int newX = pos[0] + direct[0];
                int newY = pos[1] + direct[1];
                int node2 = newX * n + newY;
                if (newX < 0 || newY < 0 || newX >= m || newY >= n ||!uf.isValid(node2)) {
                    continue;
                }
                uf.union(node1, node2);                     
            }
            res.add(uf.getCount());
        }
        
        return res;
    }
    
    class UnionFind{
        private Map<Integer, Integer> parents;
        private int[] ranks;
        private int count;
        
        public UnionFind(int n) {
            count = 0;
            parents = new HashMap<>();
            ranks = new int[n];
        }
        public int getCount() {
            return count;
        }
        public void add(int x) {
            parents.put(x,x);
            count++;     
        }
        
        public boolean isValid(int x){
            return parents.containsKey(x);
        }
        public int find(int x) {
            int parent = parents.get(x);
            if(parent != x) {
                parents.put(x, find(parent));
            }
            return parents.get(x);
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if(px == py) {
                return;
            }
            if(ranks[px] < ranks[py]) {
                parents.put(px, py);
            }else if(ranks[py] < ranks[px]) {
                parents.put(py, px);
            }else{
                parents.put(py, px);
                ranks[px]++;
            }
            count--;
        }
    }
    
    //Array[n + 1]
    class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> res = new ArrayList<>();
            if(positions == null || positions.length == 0 || positions[0].length == 0) {
                return res;
            }  
            
            UnionFind uf = new UnionFind(m * n);
            int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
            int count = 0;
            
            for (int[] pos : positions) {
                int node1 = pos[0] * n + pos[1];
                uf.add(node1);
                boolean isUnion = false;
                for (int[] direct : directions) {
                    int newX = pos[0] + direct[0];
                    int newY = pos[1] + direct[1];
                    int node2 = newX * n + newY;
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n ||!uf.isValid(node2)) {
                        continue;
                    }
                    
                    uf.union(node1, node2);                     
                }
                res.add(uf.getCount());
            }
            return res;
        }
        
    }

    class UnionFind{
            private int[] parents;
            private int[] ranks;
            private int count;
            
            public UnionFind(int n) {
                count = 0;
                parents = new int[n + 1];
                ranks = new int[n + 1];
                //Arrays.fill(parents, -1);//O(m*n)
            }
            public int getCount() {
                return count;
            }
            public void add(int x) {
                parents[x] = x + 1;
                count++;
            }
            
            public boolean isValid(int x){
                return parents[x] != 0;
            }
            public int find(int x) {
                if(parents[x] != x + 1) {
                    parents[x] = find(parents[x] - 1) ;
                }
                return parents[x];
            }
            
            public void union(int x, int y) {
                int px = find(x), py = find(y);
                if(px == py) {
                    return;
                }
                if(ranks[px] < ranks[py]) {
                    parents[px - 1] = py;
                }else if(ranks[py] < ranks[px]) {
                    parents[py - 1] = px;
                }else{
                    parents[py- 1] = px;
                    ranks[px]++;
                }
                count--;
            }
        }
}
