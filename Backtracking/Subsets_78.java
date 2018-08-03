package Backtracking;

public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backTrack(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void backTrack(int[] nums,List<List<Integer>> res,List<Integer> tempList, int start){
        res.add(new ArrayList<>(tempList)); //add copy of tempList from upper level
        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backTrack(nums,res,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    
    //Iteration
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        res.add(tmp);
        for(int num:nums){
            int n=res.size();
            for(int j=0;j<n;j++){
                tmp=new ArrayList<>(res.get(j)); //copy of res.get(j)
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}
