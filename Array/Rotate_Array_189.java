package Array;

public class Rotate_Array_189 {
	//Reverse
	public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    
    private void reverse(int[]nums, int low, int high){
        
        while(low<high){
        int temp=0;
        temp=nums[high];
        nums[high]=nums[low];
        nums[low]=temp;
        low++;
        high--;
        }
    }
    //Clone New Array
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int[] old=nums.clone();
        for(int i=0;i<nums.length;i++){
            nums[(i+k)%nums.length]=old[i];
        }
    }
    //Rotate
    public void rotate(int[] nums, int k) {
    	k%=nums.length;
        while(k-->0){
            int temp=nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
                nums[i+1]=nums[i];
            }
            nums[0]=temp;
        }
    }
}
