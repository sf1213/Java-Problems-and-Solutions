package Two_Pointer;

public class Valid_Triangle_Number_611 {
	public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0; 
        }
        
        Arrays.sort(nums);
        int count = 0;
        for(int i = 2; i < nums.length; i++){
            int left = 0, right = i - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum > nums[i]){
                    count += right - 1 - left + 1;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return count;
    }
}
