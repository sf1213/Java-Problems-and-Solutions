package Binary_Search;

public class Search_in_Rotated_Sorted_Array_II_81 {
	//Template 1, 0ms
	public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0) return false;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid]) return true;
            if((nums[start]==nums[mid])&&(nums[end]==nums[mid])){//eg:1,3,1,1,1
                start++;
                end--;
            }else if(target<nums[start]){//target is on right half (target<start)
            	 //mid on the right half too (mid<start) && target<mid
                if(nums[mid]<nums[start] && target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{     //target is on left half (target>=start)
                //mid on the left half too (mid>=start) && target>mid
                if(nums[mid]>=nums[start] && target>nums[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        
        return false;
    }
}
