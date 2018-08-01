package Binary_Search;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {
	public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int start=0,end=nums.length-1;
        while(start<end){
            if(nums[start]<nums[end]) return nums[start];
            int mid=start+(end-start)/2;
            if(nums[mid]>=nums[start]){  //when only two left, mid==start
                start=mid+1;
            }else{
                end=mid;
                start++; //mid must < start
            }
        }
        return nums[start];
    }
}
