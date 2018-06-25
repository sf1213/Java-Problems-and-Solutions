package LeetCode;

public class single_number136 {
	//use bit operator XOR
	//		b^a^b=a
	public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }

}
