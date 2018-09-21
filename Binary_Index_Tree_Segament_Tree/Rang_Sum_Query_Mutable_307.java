package Binary_Index_Tree_Segament_Tree;

public class Rang_Sum_Query_Mutable_307 {
	//Binary Indexed Tree - use update method to initialize BIT

class NumArray {
  FenwickTree ft;
  int[] nums;
  public NumArray(int[] nums) {  
      this.nums = Arrays.copyOf(nums, nums.length);      
      ft = new FenwickTree(nums.length);
      for(int i = 0; i < nums.length; i++) { 
          ft.updateTree(i, nums[i]); //O(nlogn)
      }
  }  
  public void update(int i, int val) { //O(logn)
      ft.updateTree(i, val - nums[i]);
      nums[i] = val;
  }  
  public int sumRange(int i, int j) {  //O(logn)
      return ft.query(j) - ft.query(i - 1);
  }
}
class FenwickTree {
  private int[] sums;
  public FenwickTree(int n) {
      sums = new int[n + 1];
  }  
  public void updateTree(int i, int val) {
      int index = i + 1;
      while(index < sums.length) {
        sums[index] += val;
        index += lowbit(index);
      }       
  }  
  public int query(int i) {
      int index = i + 1;
      int sum = 0;
      while(index > 0) {
          sum += sums[index];
          index -= lowbit(index);
      }   
      return sum;
  } 
  private int lowbit(int i) {
      return i & (-i);
  }    
}

//Binary Index Tree - Use accumulating sum to build tree

class NumArray {
  FenwickTree ft;
  int[] nums;
  public NumArray(int[] nums) {  //O(n)
      this.nums = Arrays.copyOf(nums, nums.length);        
      ft = new FenwickTree(nums);        
  }  
  public void update(int i, int val) { //O(logn)
      ft.updateTree(i, val - nums[i]);
      nums[i] = val;
  }  
  public int sumRange(int i, int j) {  //O(logn)
      return ft.query(j) - ft.query(i - 1);
  }
}
class FenwickTree {
  private int[] sums;
  public FenwickTree(int[] nums) {
      int[] accum_nums = new int[nums.length + 1];
      sums = new int[nums.length + 1];
      int sum = 0;
      for(int i = 1; i < accum_nums.length; i++) {
          sum += nums[i - 1];
          accum_nums[i] = sum;
      }      
      for(int j = sums.length - 1; j >= 1; j--) {
          int num1 = accum_nums[j];
          int num2 = accum_nums[j - lowbit(j)];
          sums[j] = num1 - num2;
      }
  }
  
  public void updateTree(int i, int val) {
      int index = i + 1;
      while(index < sums.length) {
        sums[index] += val;
        index += lowbit(index);
      }       
  }  
  public int query(int i) {
      int index = i + 1;
      int sum = 0;
      while(index > 0) {
          sum += sums[index];
          index -= lowbit(index);
      }   
      return sum;
  }  
  private int lowbit(int i) {
      return i & (-i);
  }    
}
}
