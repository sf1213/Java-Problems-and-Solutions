package LeetCode;

public class Move_Zeroes_283 {
	//fast pointer skip all 0, slow pointer move 1 step each time to put non-zero at the front, and fill remaining space with 0 
    public void moveZeroes(int[] nums) {
       if(nums==null||nums.length==0) return;      
       int slow=0,fast=0;      
       for(;fast<nums.length;fast++){            
           if(nums[fast]!=0){               
               nums[slow]=nums[fast];
               slow++;
           }            
       }       
       while(slow<nums.length){
           nums[slow]=0;
           slow++;
       }
       
        //Or in a more concise way
       int index=0;
       for(int num:nums){
           if(num!=0){
               nums[index++]=num;
           }
       }
       while(index<nums.length){
           nums[index++]=0;
       }
   }
    
    //Swapping solution with single loop
    public void moveZeroes(int[] nums) {
        int index=-1; //the last index of non-zero array
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[++index]=nums[i];
                if(i!=index){
                nums[i]=0; //if num!=0, swap 0 and num
            }
            }
            
        }
        
    }

}
