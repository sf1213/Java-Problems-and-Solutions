package Backtracking;

public class Permutations_II_47 {
	//BackTracking, 4ms
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        Arrays.sort(nums);
        boolean[]visited=new boolean[nums.length];
        backTrack(res,tmp,visited,nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer>tmp,boolean[]visited,int[]nums){
        if(tmp.size()==nums.length) res.add(new ArrayList<>(tmp));
        else{
            for(int i=0;i<nums.length;i++){
                     //nums[i] has been visisted or (i==i-1&& nums[i-1] hasn't been visited)
                if(visited[i]||i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
                tmp.add(nums[i]);
                visited[i]=true;
                backTrack(res,tmp,visited,nums);
                tmp.remove(tmp.size()-1);
                visited[i]=false;
            }
        }        
    }
}
