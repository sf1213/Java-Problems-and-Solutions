package Two_Pointer;

public class Two_Sum_Greater_than_target_443_Lin {
	public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] > target){
                count += right - 1 - left + 1;
                right--;
            }else{
                left++;
            }
        }
        return count;
    }
}
