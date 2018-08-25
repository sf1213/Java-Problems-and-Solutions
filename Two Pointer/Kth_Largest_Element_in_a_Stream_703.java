package Priority_Queue;

public class Kth_Largest_Element_in_a_Stream_703 {
	class KthLargest {
	    
	    PriorityQueue<Integer> pq;
	    int n;

	    public KthLargest(int k, int[] nums) { //O(nlogk)
	        pq = new PriorityQueue<>();
	        n = k;
	        for(int num : nums){
	            pq.offer(num);
	            if(pq.size() > n){
	                pq.poll();
	            }
	        }
	    }
	    
	    public int add(int val) {   //O(logk)
	        pq.offer(val);
	        if(pq.size() > n){
	            pq.poll();
	        }
	        
	        return pq.peek();
	    }
	}
}
