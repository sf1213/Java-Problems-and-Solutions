package Priority_Queue;

public class Kth_Smallest_Numbers_in_Unsorted_Array_461_Lin {
	//QuickSelect
	public int kthSmallest(int k, int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int low = 0, high = nums.length - 1;
        while(low < high){
            int index = partition(nums, low, high);
            if(index < k - 1){
                low = index + 1;
            }else if(index > k - 1){
                
                high = index - 1;
            }else{
                break;
            }
        }
        
        return nums[k - 1];
    }
    
    private int partition(int[] nums, int low, int high){
        int left = low - 1, right = high;
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        swap(nums, pivotIndex, high);
        
        int pivot = nums[high];
        while(left < right){
            do{ left++; } while(nums[left] < pivot);
            do{ right--; } while(left < right && nums[right] > pivot);
            
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, left, high);
        return left;
    }
    
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    //Arrays.sort()
    public int kthSmallest(int k, int[] nums) {
        Arrays.sort(nums);
        return nums[k - 1];
    }
    
    //PriorityQueue
    public int kthSmallest(int k, int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > nums.length - k + 1){
                pq.poll();
            }
        }
        return pq.peek();
     }
    
    //Three-way QuickSelect
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return partition(nums, 0, nums.length - 1, k);
    }
    
    private int partition(int[] nums, int left, int right, int k){
        Random rand = new Random();
        int pivotIndex = rand.nextInt(right - left + 1) + left;
        swap(nums, pivotIndex, left);
        int pivot = nums[left];
        int lt = left, gt = right, i = left + 1;
        while(i <= gt){
            if(nums[i] < pivot){
                swap(nums, i++, lt++);
            }else if(nums[i] > pivot){
                swap(nums, i, gt--);
            }else{
                i++;
            }
        }
        
        if(k - 1 < gt){
            return partition(nums, left, gt - 1, k);
        }else if(k - 1 > lt){
            return partition(nums, lt + 1, right, k);
        }else{
            return nums[k - 1];
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
