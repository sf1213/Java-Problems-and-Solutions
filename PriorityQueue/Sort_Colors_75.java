package Priority_Queue;

public class Sort_Colors_75 {
	//Similar to 3-way quick sort
	public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        
        int i = 0, lt = 0, gt = nums.length - 1;
        while(i <= gt){
            if(nums[i] == 0){
                if(nums[lt] != 0){
                    swap(nums, i, lt);
                }
                i++;
                lt++;              
            }else if(nums[i] == 1){
                i++;
            }else{
                if(nums[gt] != 2){
                    swap(nums, i, gt);
                }
                gt--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        // nums[i] ^= nums[j];
        // nums[j] ^= nums[i];
        // nums[i] ^= nums[j];
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
