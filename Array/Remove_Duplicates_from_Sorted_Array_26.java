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
	
	//general solution
	public int removeDuplicates(int[] nums) {
        int i=0;
       for(int num:nums){            //nums[i] is the one we want to build
           if(i<1||nums[i-1]<num){  //from the k+1 one, if k number before current number i is less than current num
               nums[i++]=num;       // give current number to nums[i]
           }           
       }
       return i;
   }
}
