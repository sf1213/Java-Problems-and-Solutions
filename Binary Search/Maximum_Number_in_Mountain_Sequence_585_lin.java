package Binary_Search;

public class Maximum_Number_in_Mountain_Sequence_585_lin {
	public int mountainSequence(int[] nums) {
        if(nums  == null || nums.length == 0){
            return -1;
        }       
        int start = 0, end = nums.length -1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }        
        return nums[start];
    }
}
