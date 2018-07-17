package StackPriorityQueue;

public class Longest_Absolute_File_Path_388 {
	//Deque (Stack)
    public int lengthLongestPath(String input) {
        Deque<Integer> stack=new ArrayDeque<>();
        int lev=0,maxLength=0;
        stack.push(0);
        for(String str:input.split("\n")){
            lev=str.lastIndexOf("\t")+1;//number of \t
            while(lev+1<stack.size()) stack.pop();//find parent
            //length=parents'length+str.length-(number of "\t")+"/"
            int len=stack.peek()+str.length()-lev+1;
            stack.push(len);
            if(str.contains("."))//record file's maxLength
                maxLength=Math.max(maxLength,len-1);//len-the first"/"        
        }
        return maxLength;
    }
    
  //Deque (Stack)
    public int lengthLongestPath(String input) {
        String[] path=input.split("\n");
        //use array to store str.length()
        int[] stack=new int[path.length+1];//put dummy 0 in[0]
        int lev=0,maxLength=0;
        for(String str:path){
            lev=str.lastIndexOf("\t")+1;//number of \t            
            //length=parents'length+str.length-(number of "\t")+"/"
            int len=stack[lev]+str.length()-lev+1;
            stack[lev+1]=len;
            if(str.contains("."))//record file's maxLength
                maxLength=Math.max(maxLength,len-1);//len-the first"/"        
        }
        return maxLength;
}
