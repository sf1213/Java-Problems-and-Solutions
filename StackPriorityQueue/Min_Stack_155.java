package StackPriorityQueue;

public class Min_Stack_155 {
	//One stack,double push 
	class MinStack {
	    int min;
	    Stack<Integer> stack;
	    public MinStack() {
	        stack=new Stack<>();
	        min=Integer.MAX_VALUE;
	    }	    
	    public void push(int x) {
	       //push the bigger one first
	        if(x<=min){//==min need to push twice too
	            stack.push(min);
	            min=x;
	        }
	        stack.push(x);            	        
	    }	    
	    public void pop() {
	        if(stack.isEmpty()) return;
	        if(stack.pop()==min)//pop twice,min change to the bigger one
	            min=stack.pop();       
	    }	    
	    public int top() {
	        return stack.peek();        
	    }	    
	    public int getMin() {
	        return min;
	    }
	}
	//Same space, more concise. Two stack,only push the smaller one
	class MinStack {
	    Stack<Integer> s1;
	    Stack<Integer> s2;
	    public MinStack() {
	        s1=new Stack<>();
	        s2=new Stack<>();
	    }
	    
	    public void push(int x) {
	        s1.push(x);
	        if(s2.isEmpty()||x<=s2.peek()) s2.push(x);         
	    }
	    
	    public void pop() {
	        if(s1.isEmpty()) return;
	        if(Objects.equals(s1.pop(),(s2.peek())))//Integer 
	                s2.pop();     
	    }
	    
	    public int top() {
	        return s1.peek();        
	    }
	    
	    public int getMin() {
	        return s2.peek();
	    }
	}
	
	//store the gap between the min value and the current value
	class MinStack {
	    long min;
	    Stack<Long> stack;
	    /** initialize your data structure here. */
	    public MinStack() {
	        stack=new Stack<>();
	    }
	    
	    public void push(int x) {
	        if(stack.isEmpty()){
	            stack.push(0L);
	            min=x;
	        }else{
	            stack.push(x-min);//store gap between cur.min
	            if(x<min) min=x;
	        }
	    }
	    
	    public void pop() { 
	        long pop=stack.pop();
	        if(pop<0)  min=min-pop;  
	    }
	    
	    public int top() {
	        long peek=stack.peek();
	        if(peek<0){
	            return (int)min;
	        }else{
	            return (int)(min+peek);
	        }
	    }
	    
	    public int getMin() {
	        return (int)min;
	    }
	}
	
	//ListNode
		class MinStack {
		    private Node head;
		    private class Node{
		        int val;
		        int min;
		        Node next;
		        private Node(int num,int min,Node next){
		            this.val=num;
		            this.min=min; 
		            this.next=next;
		        }
		    }
		    public void push(int x) {
		        if(head==null){
		            head=new Node(x,x,null);
		        }else{
		            head=new Node(x,Math.min(x,head.min),head);
		        }
		    }	    
		    public void pop() {
		        if(head!=null){
		            head=head.next;
		        }       
		    }	    
		    public int top() {
		        if(head!=null) return 
		            head.val;
		        return -1;//stack is empty
		    }	    
		    public int getMin() {
		        if(head!=null)
		            return head.min;
		        return -1; //stack is empty
		    }
		}

}
