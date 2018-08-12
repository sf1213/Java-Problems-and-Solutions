package Bit_Manipulation;

public class Single_Number_II_137 {

	public int singleNumber(int[] nums) {
	    int a=0, b=0; //design a counter to record state
	    for(int num:nums){
	        int tmpa = (a & ~b & ~num) | (~a & b & num);
	        b =  (~a & b & ~num) | (~a & ~b & num);
	        a=tmpa;
	    }
	    return a|b;
	}
	

	public int singleNumber(int[] nums) {
	    int a=0, b=0; //design a counter to record state
	    for(int num:nums){
	        b = (b^num) & (~a);
	        a = (a^num) & (~b); //b is from last step
	    }
	    return a|b;
	}   
}
