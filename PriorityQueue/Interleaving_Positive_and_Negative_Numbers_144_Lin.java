package Priority_Queue;

public class Interleaving_Positive_and_Negative_Numbers_144_Lin {
	public void rerange(int[] A) {
        if(A == null || A.length == 0){
            return;
        }
         int len = A.length;
       int negativeNum =  partition(A, 0, len - 1);
        int positiveNum = len - negativeNum;
        if(negativeNum == positiveNum){
            interleave(A, 0, len - 1);
        }else if(negativeNum < positiveNum){
            interleave(A, 0, len - 2);
        }else{
            interleave(A, 1, len - 1);
        }
    }
    
    public int partition(int[] nums, int low, int high){
        int left = low - 1;
        int right = high + 1;
        while(left < right){
            do{ left++; } while(left < right && nums[left] < 0);
            do{ right--; } while(left < right && nums[right] > 0);
            
            if(left < right){
                swap(nums, left, right);
            }
            
        }
        
        return left; //no. of negative
    }
    
    private void interleave(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left += 2;
            right -= 2;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
