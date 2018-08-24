package Two_Pointer;

public class Sliding_Window_Maximum_239 {
	//TreeSet, 36ms
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        
        int[] max = new int[nums.length - k + 1];
        
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                if(nums[a] == nums[b]){
                    return a.compareTo(b);
                }               
                return nums[a] < nums[b] ? -1 : 1;
            }
        });
                
        for(int i = 0; i < nums.length; i++){
            set.add(i);            
            if(set.size() == k){
                int index = i - k + 1;
                max[index] = nums[set.last()];  
                set.remove(index);                
            }
        }       
        return max;
    }
	
	//Deque, 11ms
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        
        int[] max = new int[nums.length - k + 1];        
        Deque<Integer> que = new ArrayDeque<>(); //record index
                
        for(int i = 0; i < nums.length; i++){
            if(!que.isEmpty() && que.peekFirst() < i - k + 1){ //remove index out of range
                que.pollFirst();
            }
            
            while(!que.isEmpty() && nums[i] >= nums[que.peekLast()]){ //make sure max is at front
                que.pollLast();										  //remove smaller ones
            }
            
            que.offerLast(i);
            
            if(i >= k - 1){
                max[i - k + 1] = nums[que.peekFirst()];              
            }
        }
        
        return max;
    }
	
	//Two Array, 3ms
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        int len = nums.length;
        
        int[] left = new int[len];
        left[0] = nums[0];
        int[] right = new int[len];
        right[len - 1] = nums[len - 1];
        int[] max = new int[len - k + 1];
        
        for(int i = 1; i < len; i++){
            left[i] = (i % k == 0) ? nums[i] : Math.max(left[i - 1], nums[i]);
        }
        
        for(int j = len - 2; j >= 0; j--){
            right[j] = (j % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
        }
        
        for(int m = 0; m < len - k + 1; m++){
            max[m] = Math.max(right[m], left[m + k - 1]);
        }
       
        return max;
    }
}
