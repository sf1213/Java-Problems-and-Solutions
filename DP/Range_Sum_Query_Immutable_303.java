package DP;

public class Range_Sum_Query_Immutable_303 {

  class NumArray {
    private int[] sums;
    int[] nums;
    public NumArray(int[] nums) { //O(n)
      this.nums = nums;
      sums = new int[nums.length];
      int sum = 0;
      for(int i = 0; i < nums.length; i++) {
        sums[i] = nums[i] + sum;
        sum = sums[i];
      }
    }
    public int sumRange(int i, int j) { //O(1)
      if(i == 0) {
        return sums[j];
      }
      return sums[j] - sums[i - 1];
    }
  }
  
}
