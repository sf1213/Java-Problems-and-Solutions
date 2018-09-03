package Two_Pointer;

public class FourSum_18 {

public List<List<Integer>> fourSum(int[] nums, int target) {
  List<List<Integer>> res = new ArrayList<>();
  int len = nums.length;
  if(nums == null || len < 4){
      return res;
  }  
  Arrays.sort(nums);
  int sum = 0;
  for(int i = 0; i < len - 3; i++){
      if(i > 0 && nums[i] == nums[i - 1]){ //skip dulplicates
          continue;
      }      
      if(nums[i] * 4 > target){ //too big, break for loop
          break;
      }
      if(nums[i] + nums[len - 1] * 3 < target){ //too small, continue next loop
          continue;
      }
      for(int j = i + 1; j < len - 2; j++){
          if(j > i + 1 && nums[j] == nums[j - 1]){ //skip dulplicates
              continue;
          }          
          if(nums[j] * 3 > target - nums[i]){ //too big
              break;
          }
          if(nums[j] + nums[len - 1] * 2 < target - nums[i]){ //too small
              continue;
          }
          int left = j + 1, right = len - 1;
          while(left < right){
              sum = nums[i] + nums[j] + nums[left] + nums[right];
              if(sum == target){
                  res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                  left++;
                  right--;                                       //skip dulplicates
                  while(left < right && nums[left] == nums[left - 1]){
                      left++;
                  }                                             //skip dulplicates
                  while(left < right && nums[right] == nums[right + 1]){ ≈
                      right--;
                  }
              }else if(sum < target){
                  left++;
              }else{
                  right--;
              }
          }
          
      }
  }
  
  return res;
}
}
