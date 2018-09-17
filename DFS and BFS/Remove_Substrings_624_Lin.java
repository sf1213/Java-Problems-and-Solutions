package DFS_BFS;

public class Remove_Substrings_624_Lin {
	//BFS, Why memory exceed ????
	public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (dict == null || dict.size() == 0) {
            return s.length();
        }        
        Queue<String> que = new ArrayDeque<>();
        int min = s.length();        
        que.offer(s);
        while(!que.isEmpty()) {
            String str = que.poll();
            min = Math.min(str.length(), min);
            Set<String> tmp = findAll(dict, str);
            for(String newStr : tmp) {
                que.offer(newStr);
            }
        }
        return min;
    }
    
    private Set<String> findAll(Set<String> dict, String s) {        
        Set<String> res = new HashSet<>();
        int index = -1;
        for (String sub : dict) {
            index = s.indexOf(sub);
            while(index != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0 , index));
                sb.append(s.substring(index + sub.length() , s.length()));
                
                res.add(sb.toString());
                
                index = s.indexOf(sub, index + 1);
            }
        }
        return res;
    }
    
    //BFS 2
    if (s == null || s.length() == 0) {
        return 0;
    }
    if (dict == null || dict.size() == 0) {
        return s.length();
    }
    
    Queue<String> que = new LinkedList<>();
    Set<String> set = new HashSet<>();
    int min = s.length();
    int index = -1;
    
    que.offer(s);
    set.add(s);
    while(!que.isEmpty()) {
        String str = que.poll();
        min = Math.min(str.length(), min);
        for (String sub : dict) {
            index = str.indexOf(sub);
            while(index != -1) {
                String newStr = str.substring(0 , index) + str.substring(index + sub.length());
                if(!set.contains(newStr)) {
                    set.add(newStr);
                    que.offer(newStr);
                }
                index = str.indexOf(sub, index + 1);
            }
        }
    }
        
    return min;
}
}
