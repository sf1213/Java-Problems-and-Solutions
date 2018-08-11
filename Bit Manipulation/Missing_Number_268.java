package Bit_Manipulation;

public class Missing_Number_268 {
	//Bit Manipulation, 1ms
    public int missingNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=i^nums[i];
        }
        return result^nums.length;
    }
    
   //sum, 0ms
    public int missingNumber(int[] nums) {
        int sum=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=i-nums[i];
        }
        return sum;
    }
    
  //Binary Search, 7ms
    public int missingNumber(int[] nums) {
        Arrays.sort(nums); //nlogn
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid<nums[mid]) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
