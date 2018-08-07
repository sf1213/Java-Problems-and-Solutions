package Backtracking;

public class Letter_Combinations_of_a_Phone_Number_17 {
	//BackTrack, 2ms
	String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        StringBuilder tmp=new StringBuilder();
        backTrack(res,tmp,digits,0);
        return res;
    }
    private void backTrack(List<String> res,StringBuilder tmp,String digits,int index){
        if(index==digits.length()){
            res.add(tmp.toString());
            return;
        }
        String letter=map[digits.charAt(index)-'0'];
        for(int i=0;i<letter.length();i++){
            tmp.append(letter.charAt(i));
            backTrack(res,tmp,digits,index+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
    
    //BFS Iteration, 2ms
    public List<String> letterCombinations(String digits) {
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> que=new LinkedList<>();
        if(digits==null||digits.length()==0) return que;        
        que.offer("");
        for(int i=0;i<digits.length();i++){  //for each digit,eg:23
            String letter=map[digits.charAt(i)-'0'];//find corresponding string
            while(que.peek().length()==i){ //combine all the character with all the elements in que
                String cur=que.poll();
                for(int j=0;j<letter.length();j++){
                    que.offer(cur+letter.charAt(j));
                }
            }
        }
        
        return que;
    }
}
