package String;

public class Implement_strStr_28 {
	//straight forward slow way
	public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack==null||haystack.length()==0||haystack.length()<needle.length()) return -1;
        
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int a=i+1;
                int j=1;
                for(;j<needle.length();j++){ 
                    if(a>haystack.length()-1) break;
                    if(haystack.charAt(a)!=needle.charAt(j)) {
                        break;
                    }
                    a++;                   
                }
                if(j>needle.length()-1) return i;             
            }
        }
        return -1;
    }
	//clever and quick way
	public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;//corner case
        
        for(int i=0;i<=haystack.length()-needle.length();i++){ //only need to search from 0~(h.length-n.length)
            //go into inner loop only if haystack.charAt(i+j)==needle.charAt(j)
            for(int j=0;j<needle.length()&&haystack.charAt(i+j)==needle.charAt(j);j++){
                if(j==needle.length()-1) return i; //if j reaches the end of needle, there is a match
            }
        }
        return -1;
    }
}
