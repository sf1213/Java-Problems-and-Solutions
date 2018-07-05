package Array;

public class Remove_Duplicates_from_Sorted_Array_26 {
	public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[a]){
               nums[++a]=nums[i];
            }
            
        }
        return a+1;
    }
}
