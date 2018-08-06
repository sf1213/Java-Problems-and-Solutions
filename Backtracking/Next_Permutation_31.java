package Backtracking;

public class Next_Permutation_31 {
	//Narayana Pandita's Algorithm, 11ms
	public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0) return;
        int i,j;
        for(i=nums.length-2;i>=0;i--){ //find the largest index i that nums[i]<nums[i+1]
            if(nums[i]<nums[i+1]) break;
        }
        if(i>=0){ //if i<0, skip this part
            for(j=nums.length-1;j>i;j--){//find the largest index j that nums[j]>nums[i]
                if(nums[j]>nums[i]) break;
            }
            swap(nums,i,j); //swap i ,j
        }
        
        reverse(nums,i+1,nums.length-1);
    }
    private void swap(int[]nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void reverse(int[]nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }                
    }
}
