package Two_Pointer;

public class Two_Sum_Less_than_or_equal_to_target_609_Lin {
	public int twoSum5(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;

        while(left < right){
            if(nums[left] + nums[right] <= target){
                count += right - (left + 1) + 1;
                left++;
            }else{
                right--;
            }
        }      
        return count;
   }
}
