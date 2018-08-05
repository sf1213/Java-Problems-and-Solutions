package Backtracking;

public class Combination_Sum_III_216 {
	//BackTracking, 0ms
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        backTrack(res,tmp,k,n,1);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tmp,int k,int remain,int start){
        if(k==0&&remain==0) res.add(new ArrayList<>(tmp));
        else if(k>0){  //if k==0||remain==0, backTrack do nothing,s size-1 and continue next loop
            for(int i=start;i<10;i++){
                if(remain<i) return; //return to upper level
                tmp.add(i);
                backTrack(res,tmp,k-1,remain-i,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
