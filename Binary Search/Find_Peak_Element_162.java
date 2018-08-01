package Binary_Search;

public class Find_Peak_Element_162 {
	//Sequential
	public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
               return i;
        }       
        return nums.length-1;
    }
	
	//Binary Search
	public int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int start=0,end=nums.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }else{   //nums[mid]>=nums[mid+1]
                end=mid;
            }
        }
        return start;
    }
}
