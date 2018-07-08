package String;

public class Longest_Common_Prefix_14 {
	//Compare all letters' first char, then all letters' second char...... O(n*k)
	public String longestCommonPrefix(String[] strs) {
        StringBuilder res=new StringBuilder();
        if(strs==null||strs.length==0) return new String(res);
        if(strs.length==1) return strs[0];
        for(int j=0; j<strs[0].length(); j++){
                char x=strs[0].charAt(j);
        
            for(int i=1;i<strs.length;i++){
                if(j>strs[i].length()-1||strs[i].charAt(j)!=x) return new String(res);
                if(i==strs.length-1) res.append(x);
            }
            
        }
        
        return new String(res);
    }
	//Compare each letter with the first letter, record the length of same characters.O(n*k)
	public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        int length=strs[0].length();
        //Compare each letter with the first letter
        for(int i=1;i<strs.length;i++){
            length=Math.min(length,strs[i].length());
            for(int j=0;j<length;j++){   //compare start from the first character, end at length
                if(strs[0].charAt(j)!=strs[i].charAt(j)){
                    length=j;
                    break;
                }
            }
        }
        return strs[0].substring(0,length);
    }
}
