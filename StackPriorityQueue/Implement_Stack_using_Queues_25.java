package StackPriorityQueue;

public class Implement_Stack_using_Queues_25 {
	//Stack top as Queue back, pop() and top() all take O(n) time
	class MyStack {
	    Queue<Integer> q=new LinkedList<>();    
	    public void push(int x) {
	        q.offer(x);
	    }    
	    public int pop() {
	        int n=q.size();
	        while(n-->1){
	            q.offer(q.poll());
	        }
	        return q.poll();
	    }   
	    public int top() {
	        int n=q.size();
	        while(n-->1){
	            q.offer(q.poll());
	        }
	        int top=q.peek();
	        q.offer(q.poll());
	        return top;
	    }
	    
	    public boolean empty() {
	        return q.isEmpty();
	    }
	}
	//Stack bottom as Queue front, only push take O(n) time
	class MyStack {
	    Queue<Integer> q=new LinkedList<>();    
	    public void push(int x) {
	        q.offer(x);
	        int n=q.size();
	        while(n-->1){
	            q.offer(q.poll());
	        }
	    }    
	    public int pop() {
	        return q.poll();
	    }   
	    public int top() {
	        return q.peek();
	    }
	    
	    public boolean empty() {
	        return q.isEmpty();
	    }
	}
	
}
