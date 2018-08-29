package Two_Pointer;

public class ThreeSum_Closest_16 {
	public int threeSumClosest(int[] nums, int target) {
        // if(nums == null || nums.length < 3){
        //     return -1;
        // }
        
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for(int i = 2; i < nums.length; i++){
            int left = 0, right = i - 1;
            while(left < right){
                int sum = nums[i]+ nums[left] + nums[right];
                if(sum == target){
                    return target;
                }else if(sum > target){
                    right--;
                }else{
                    left++;
                }
                
                if(Math.abs(sum - target) < Math.abs(bestSum - target)){ //if overflow, use long type
                    bestSum = sum;
                }
            }
        }
        return bestSum;
    }
}
