package Two_Pointer;

public class Sliding_Window_Median_480 {
	//PriorityQueue, 38ms
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new double[]{};
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b.compareTo(a); //b - a may overflow
            }
        });
        double[] res = new double[nums.length - k + 1];
        double med = 0.0;
        
        for(int i = 0; i < nums.length; i++){            
            if(maxHeap.size() <= minHeap.size()){ //maintain maxHeap size = minHeap or minHeap + 1
                minHeap.offer(nums[i]);
                maxHeap.offer(minHeap.poll());
            }else{
                maxHeap.offer(nums[i]);
                minHeap.offer(maxHeap.poll());
            }
            
            int max = maxHeap.peek();
            int index = i - k + 1;
            if(maxHeap.size() + minHeap.size() == k){
                if(k % 2 == 0){
                    med = max / 2.0 + minHeap.peek() / 2.0;
                }else{
                    med = max;
                }
                
                res[index] = med;
                
                if(nums[index] <= max){
                    maxHeap.remove(nums[index]); //in maxHeap, O(k)
                }else{
                    minHeap.remove(nums[index]); //in minHeap, O(k)
                }
            }
        }
        return res;
    }
	
	//TreeSet
	public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new double[]{};
        }
        
        TreeSet<Integer> left = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(nums[a] == nums[b]){
                    return a.compareTo(b);
                }
                
                //return nums[a].compareTo(nums[b]);
                return nums[a] < nums[b] ? -1 : 1;
            }
        });
        TreeSet<Integer> right = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                 if(nums[a] == nums[b]){
                    return a.compareTo(b);
                }
                
                //return nums[a].compareTo(nums[b]);
                return nums[a] < nums[b] ? -1 : 1;
            }
        });
        
        double[] res = new double[nums.length - k + 1];
        double med = 0.0;
        
        for(int i = 0; i < nums.length; i++){            
            if(left.size() <= right.size()){ //maintain left size = right or right + 1
                right.add(i);
                left.add(right.pollFirst());
            }else{
                left.add(i);
                right.add(left.pollLast());
            }
            
            int maxIndex = left.last();
            int index = i - k + 1;  //first index of current range
            if(left.size() + right.size() == k){
                if(k % 2 == 0){
                    med = nums[maxIndex] / 2.0 + nums[right.first()] / 2.0;
                }else{
                    med = nums[maxIndex];
                }
                
                res[index] = med;
                
                if(nums[index] <= nums[maxIndex]){
                    left.remove(index); //O(logk)
                }else{
                    right.remove(index); //O(logk)
                }
            }
        }
        return res;
    }
}
