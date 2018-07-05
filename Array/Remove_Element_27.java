package Array;

public class Remove_Element_27 {
	//left->right
	public int removeElement(int[] nums, int val) {       
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[a++]=nums[i];
            }
        }
        return a;
    }
	//both side->central
	public int removeElement(int[] nums, int val) {
        int n=nums.length-1;
        int i=0;
        while(i<=n){
            if(nums[i]==val){
                nums[i]=nums[n--];
            }else{
                i++;
            }            
        }
        return i;
    }
}
