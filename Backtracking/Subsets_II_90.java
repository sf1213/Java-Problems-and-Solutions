package Backtracking;

public class Subsets_II_90 {
	//BackTrack, 2ms
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,tmp,nums,0);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tmp,int[]nums,int start){
        res.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            tmp.add(nums[i]);
            backTrack(res,tmp,nums,i+1);
            tmp.remove(tmp.size()-1);            
        }
    }
    
    //Iteration, 2ms
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();  
        Arrays.sort(nums);
        res.add(tmp);
        for(int i=0;i<nums.length;i++){
            int dulp=0;
            while(i+1!=nums.length&&nums[i]==nums[i+1]){
                dulp++;
                i++;
            }
            int n=res.size();
            for(int j=0;j<n;j++){
                tmp=new ArrayList<>(res.get(j));
                for(int k=0;k<=dulp;k++){
                    tmp.add(nums[i]);
                    res.add(new ArrayList<>(tmp));
                }
            }
            
        }
        return res;
    }
    
    //Iteration, More concise, 2ms
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();  
        Arrays.sort(nums);
        res.add(tmp);
        int n=0;
        for(int i=0;i<nums.length;i++){
            int start=i>0&&nums[i]==nums[i-1]? n:0; //duplicate           
            n=res.size();
            for(int j=start;j<n;j++){
                tmp=new ArrayList<>(res.get(j));                
                tmp.add(nums[i]);
                res.add(tmp);                
            }            
        }
        return res;
    }
    
}
