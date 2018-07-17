package StackPriorityQueue;

public class Basic_Calculator_224 {
	/*recursion/stack iteration*/

	class Solution {
	    int pos=0;
	    public int calculate(String s) {
//	        Deque<Integer> stack=new ArrayDeque<>(); //stack
	        int sum=0,num=0;
	        int sign=1;
	        for(int i=pos;i<s.length();i++){
	            char c=s.charAt(i);
	            if(c==' '){
	                continue;
	            }else if(Character.isDigit(c)){
	                num=num*10+c-'0';
	                if(i==s.length()-1||!Character.isDigit(s.charAt(i+1))){
	                    sum+=sign*num;   //if number has ended, +/- it to sum
	                    num=0;
	                }                   
	            }else if(c=='('){
	                 pos=i+1;
	                 int next=calculate(s);
	                 sum+=sign*next;    //end of recursion is same as end of number
	                 num=0;              
	                 i=pos;         //keep i moving forward
	               
	      /*-----------------stack------------------*/     
//	                stack.push(sum);
//	                stack.push(sign);
//	                sum=0;      //reset sum and sign
//	                sign=1;
	            }else if(c==')'){
	            	// sum+=sign*num;  
	            	pos=i;                
	                return sum;
	                 
	         /*-----------------stack------------------*/                
//	                sum=sum*stack.pop()+stack.pop();	                	                
	            }else if(c=='+'){ 
	                // sum+=sign*num;
	                //num=0;
	                sign=1;
	                
	            }else{
	                // sum+=sign*k;
	                //num=0;
	                sign=-1;                
	            }            
	        }
	        // sum+=sign*num;
	        return sum;
	    }
	}
	
	//Clever Stack
	public int calculate(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        int sum=0,num=0;
        int sign=1;
        stack.push(1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' '){
                continue;
            }else if(Character.isDigit(c)){
                num=num*10+c-'0';               
            }else if(c=='('){
                stack.push(sign);
            }else if(c==')'){
                stack.pop();         	                
            }else if(c=='+'||c=='-'){
                sum+=sign*num;
                sign=stack.peek()*(c=='+'? 1:-1);	    
                num=0;
            }else{
                sign=-1;                
            }            
        }
         sum+=sign*num;
        return sum;
    }
}
