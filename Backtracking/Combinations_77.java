package Backtracking;

public class Combinations_77 {
	//BackTracking 1, 10ms
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        backTrack(res,tmp,n,k,1);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tmp,int n,int k,int start){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            backTrack(res,tmp,n,k,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    
  //BackTracking 2, Valid Range, 2ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        backTrack(res,tmp,k,1,n-k+1);
        return res;
    }
    private void backTrack(List<List<Integer>> res,List<Integer> tmp,int k,int start,int end){
        if(k==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<=end;i++){
            tmp.add(i);
            backTrack(res,tmp,k-1,i+1,end+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
