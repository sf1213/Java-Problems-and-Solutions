package Binary_Search;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {
	//Template 2, Return minimum that may not with minimum index, 0ms
	public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int start=0,end=nums.length-1;
        while(start<end){
            if(nums[start]<nums[end]) return nums[start];
            int mid=start+(end-start)/2;
            if((nums[start]==nums[mid])&&(nums[mid]==nums[end])){
                start++;
                end--;
            }else if(nums[start]<=nums[mid]){
                start=mid+1;
            }else{
                end=mid;
                start++;
            }
        }
        return nums[start];       
    }
	
	//Template 2, More concise, Return minimum with minimum index, 0ms
	public int findMin(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[end]){
                start=mid+1;
            }else if(nums[mid]<nums[end]){
                end=mid;           
            }else{     //nums[mid]==nums[end]
                if(nums[end-1]>nums[end]) //eg:1,2,1,1,1,1
                    return nums[end]; //return duplicate minimum with minimum index
                end--;
            }
        }
        return nums[start];
        
    }
}
