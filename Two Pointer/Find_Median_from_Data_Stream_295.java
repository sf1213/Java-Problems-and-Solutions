package Priority_Queue;

public class Find_Median_from_Data_Stream_295 {
	class MedianFinder {
	    
	    PriorityQueue<Integer> minHeap, maxHeap;

	    public MedianFinder() {
	        minHeap = new PriorityQueue<>();
	        // maxHeap = new PriorityQueue<>((a, b)->(b - a));
	        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
	            public int compare(Integer a, Integer b){
	                //return b.compareTo(a);
	                return b - a;
	            }
	        });
	    }
	    
	    public void addNum(int num) {  //O(logn)
	        if(maxHeap.size() > minHeap.size()){
	            maxHeap.offer(num);
	            minHeap.offer(maxHeap.poll());
	        }else{
	            minHeap.offer(num);
	            maxHeap.offer(minHeap.poll());
	        }
	    }
	    
	    public double findMedian() {  //O(1)
	        if(maxHeap.size() == minHeap.size()){
	            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
	        }else{
	            return maxHeap.peek();
	        }
	    }
	}

}
