package Two_Pointer;

public class Two_Sum_II_Input_array_is_sorted_167 {
	//Two Pointers
	public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return null;
        }
        
        int i = 0, j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i + 1, j + 1};
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        
        return null;
    }
}
