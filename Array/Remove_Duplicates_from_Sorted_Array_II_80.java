package Array;

public class Remove_Duplicates_from_Sorted_Array_II_80 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 1;
		int a = 1;
		for (int i = 1; i < nums.length; i++) { //nums[a] is the one we want to build
			if (nums[i] == nums[i - 1]) { // if cur=prev, check if prev has appeared less than 2 times
				if (count < 2) {          //give cur to nums[a] only if count<k
					count++;
					nums[a++] = nums[i];
				}
			} else {                      // if cur!=prev, give cur to nums[a], set count to 1
				count = 1;
				nums[a++] = nums[i];
			}
		}
		return a;
	}
	
	//clever solution
	public int removeDuplicates(int[] nums) {
        int i=0;
        for(int num:nums){            //nums[i] is the one we want to build
            if(i<2||nums[i-2]<num){  //from the k+1 one, if k number before current number i is less than current num
                nums[i++]=num;       // give current number to nums[i]
            }           
        }
        return i;
    }
	
}
