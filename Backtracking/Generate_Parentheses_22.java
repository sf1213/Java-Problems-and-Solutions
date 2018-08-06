package Backtracking;

public class Generate_Parentheses_22 {
	//BackTracking, 1ms
	public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        backTrack(res,str,n,n);
        return res;
    }
    private void backTrack(List<String> res,StringBuilder str,int open,int close){
        if(open==0&&close==0){
            res.add(str.toString());
            return;
        }

        if(open>0){           
        backTrack(res,str.append('('),open-1,close);
        str.deleteCharAt(str.length()-1);
        }

        if(close>open){
            backTrack(res,str.append(')'),open,close-1);
            str.deleteCharAt(str.length()-1);
        } 
    }
}
