package String;

public class Implement_strStr_28 {
	//straight forward slow way, 639ms
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
	//clever and quick way, 5ms
	public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;//corner case
        }        
        for(int i = 0; i <= haystack.length() - needle.length(); i++){ //only need to search from 0~(h.length-n.length)
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if(j == needle.length() - 1) {
                    return i; //if j reaches the end of needle, there is a match
                }
            }
        }
        return -1;
    }
	
	//Rabin Karp, 6ms
	public int BASE = 1000000;
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int n = needle.length();
        if(needle.length() == 0) {
            return 0;
        }     
        
        int power = 1;
        for(int i = 0; i < n; i++){ //31^n
            power = (power * 31) % BASE;
        }
        
        int needleCode = 0;
        for(int i = 0; i < n; i++){ //target's hashcode
            needleCode = ((needleCode * 31) + needle.charAt(i)) % BASE;
        }
        
        int hashCode = 0;
        for(int i = 0; i < haystack.length(); i++){
            hashCode = ((hashCode * 31) + haystack.charAt(i)) % BASE;
            if(i < n - 1){  //length<n
                continue;
            }
            if(i >= n){  //abcd - a
                hashCode -= (haystack.charAt(i - n) * power) % BASE;
                if(hashCode < 0){
                    hashCode += BASE;
                }
            }
            
            if(hashCode == needleCode){
                if(haystack.substring(i - n + 1, i + 1).equals(needle)){
                    return i - n + 1;
                }
            }
        }
        return -1;
        
    }
}
