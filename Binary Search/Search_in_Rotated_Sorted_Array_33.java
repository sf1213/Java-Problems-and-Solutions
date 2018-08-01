package Binary_Search;

public class Search_in_Rotated_Sorted_Array_33 {
	//Template 3, 8ms

public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int start=0,end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(target<nums[start]){ //target is on right half (target<start)
                  //mid on the right half too (mid<start) && target<mid
                if(target<nums[mid] && nums[mid]<nums[start]){
                    end=mid;
                }else{
                    start=mid;
                }                
            }else{            //target is on left half (target>start)
                  //mid on the left half too (mid>start) && target>mid
               if(nums[mid]>nums[start] && target>nums[mid]){
                   start=mid;
               }else{
                   end=mid;
               } 
            }
        }
        if(nums[start]==target) return start;
        else if(nums[end]==target) return end;
        return -1;
    }
	//Template 1, 8ms

public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
             if(target==nums[mid])  return mid;
             if(target<nums[start]){ //target on the right half (target<start)
                    //mid also on right half (mid>start) && target<mid             
                if(nums[mid]<nums[start] && target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }                
            }else{    //target on left half, target>=start
                  //mid also on left half (mid>=start) && target>mid
               if(nums[mid]>=nums[start] && target>nums[mid]){
                   start=mid+1;
               }else{
                   end=mid-1;
               } 
            }
        }        
        return -1;
    }
}
