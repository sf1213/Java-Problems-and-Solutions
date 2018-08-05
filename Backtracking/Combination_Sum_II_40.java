package Backtracking;

public class Combination_Sum_II_40 {
	//BackTracking, 10ms
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        Arrays.sort(candidates); //O(nlogn)
        backTrack(res,tmp,candidates,0,target);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tmp,int[]nums,int start,int remain){
        if(remain==0) res.add(new ArrayList<>(tmp));
        else{
            for(int i=start;i<nums.length;i++){
                if(remain<nums[i]) return;
                else if(i>start&&nums[i]==nums[i-1]) continue; //skip duplicate
                else{
                    tmp.add(nums[i]);
                    backTrack(res,tmp,nums,i+1,remain-nums[i]); //i+1,remain-nums[i]
                    tmp.remove(tmp.size()-1);
                }                
            }
        }
    }
}
