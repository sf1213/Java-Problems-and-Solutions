package StackPriorityQueue;

public class Implement_Queue_using_Stacks_232 {
	class MyQueue {
	    Stack<Integer> input=new Stack<>();
	    Stack<Integer> output=new Stack<>();
	    public void push(int x) {
	        input.push(x);
	    }    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        peek();
	        return output.pop();
	    }    
	    /** Get the front element. */
	    //move elements from input stack to output stack when output empty
	    public int peek() {
	        if(output.isEmpty()){
	            while(!input.isEmpty()){
	                output.push(input.pop());
	            }            
	        }
	        return output.peek();
	    }    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return input.isEmpty()&&output.isEmpty();
	    }
	}
}
