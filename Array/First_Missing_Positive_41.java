package Array;

public class First_Missing_Positive_41 {
	public int firstMissingPositive(int[] nums) {
        int l=nums.length;
        for(int i=0;i<l;i++){
            //if nums[i] has the correct position, swap it to this position, nums[2]=5, then swap it to nums[4]
            while(nums[i]>0&&nums[i]<l&&nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        //find the first element with the wrong position
        for(int i=0;i<l;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return l+1;
        
    }
    
    private void swap(int[] nums, int i,int j){
        if(nums[i]!=nums[j]){
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
        }
    }
}
