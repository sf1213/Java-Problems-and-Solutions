package StackPriorityQueue;

public class Simplify_Path_71 {
	public String simplifyPath(String path) {
        StringBuilder res=new StringBuilder(); 
        if(path==null||path.length()==0) return res.toString();
        Deque<String> deque=new ArrayDeque<>();
 
		for (String str : path.split("/")) {
			if (str.equals(""))
				continue;
			else if (str.equals("."))
				continue;
			else if (str.equals(".."))
				deque.pollLast();
			else
				deque.addLast(str);
		}
        //method 1:deque.pollFirst()                             
        // while(!deque.isEmpty()){
        //     res.append("/").append(deque.pollFirst());
        // }
        // return res.length()==0? "/":res.toString();

        //method 2: String,join
        // return "/"+String.join("/",deque);
        
        //method 3: For each
        for(String s:deque){
            res.append("/").append(s);
        }
        return res.length()==0? "/":res.toString();
     }
}
