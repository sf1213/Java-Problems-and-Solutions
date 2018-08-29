package Two_Pointer;

public class Two_Sum_Closest_to_target_533 {
	public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 2){
            return -1;
        }
        
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                diff = 0;
                break;
            }else if(sum > target){
                diff = Math.min(sum - target, diff);
                right--;
            }else{
                diff = Math.min(target - sum, diff);
                left++;
            }
        }
        return diff;
    }
}
