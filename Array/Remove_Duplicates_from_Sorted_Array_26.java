package Array;

public class Remove_Duplicates_from_Sorted_Array_26 {
	//Two pointers, 8ms
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
       
       int len = 0;
       for(int i = 0; i < nums.length; i++){
           if(nums[i] != nums[len]){
               nums[++len] = nums[i];
           }
       }
       
       return len + 1;
   }
	
	//HashSet, 18ms
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
       
       Set<Integer> set = new HashSet<>();
       int len = 0;
       for(int num : nums){
           if(!set.contains(num)){
               nums[len++] = num;
               set.add(num);
           }
       }
       
       return len;
   }
}
