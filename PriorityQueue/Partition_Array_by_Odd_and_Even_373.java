package Priority_Queue;

public class Partition_Array_by_Odd_and_Even_373 {
	public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int left = -1, right = nums.length;
        while(left < right){
            do{ left++; } while(left < right && isOdd(nums[left]));
            do{ right--; } while(left < right && !isOdd(nums[right]));
            
            if(left < right){
                swap(nums, left, right);
            }
        }
    }
    
    private boolean isOdd(int num){
        return num % 2 != 0;
    }
    
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
