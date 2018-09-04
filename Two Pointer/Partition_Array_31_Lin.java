package Two_Pointer;

public class Partition_Array_31_Lin {

	public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0){
	        return 0;
	    }    
	    int left = -1, right = nums.length;
	    while(left < right){
	        do{ left++; } while(left < right && nums[left] < k);
	        do{ right--;} while(left < right && nums[right] >= k);
	        
	        if(left < right){
	            swap(nums, left, right);
	        }
	    }    
	    return left;        
	}
	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}
