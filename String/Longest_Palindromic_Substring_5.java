package String;

public class Longest_Palindromic_Substring_5 {
	//Central point enumeration, 14ms
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int len = 0,longest = 0,start = 0; //start index
        for(int i = 0;i < s.length();i++){ //one character
            len = palindromeLen(s, i, i);
            if(len > longest){
                longest = len;
                start = i - len / 2; //odd
            }
            
            len = palindromeLen(s, i, i + 1); //two character
            if(len > longest){
                longest = len;
                start = i - len / 2 + 1; //even
            }
        }
        
        return s.substring(start, start+longest);        
    }
    
    private int palindromeLen(String s, int left, int right){
        int len = 0;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }else{
                len += left == right ? 1 : 2;
            }
            left--;
            right++;
        }
        return len;
    }
    
    //DP, 58ms
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int longest = 0, start=0;
        int n = s.length();
        boolean[][] isPali = new boolean[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(i == j){ //one character
                    isPali[i][j] = true;
                }else if(i + 1 == j){ //two adjacent character
                    isPali[i][j] = s.charAt(i) ==s.charAt(j);
                }else{
                    isPali[i][j] = isPali[i+1][j-1] && s.charAt(i) ==s.charAt(j);
                }
                
                if(isPali[i][j] && j-i+1 > longest){
                    longest = j-i+1;
                    start = i;
                }
            }
        }
        
        return s.substring(start,start+longest);
        
    }
    
    //Manancher's Algorithm, 15ms
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        String str = generate(s); //abc->#a#b#c#
        int[] RL = new int[str.length()];
        int longest = 0, mid=0;
        for(int i = 0; i < str.length(); i++){
            int len = 1;
            if(mid + longest > i){ //i at the left of maxRight
                int mirror = mid - (i - mid); //mid-(length between i and mid)
                len = Math.min(RL[mirror], mid + longest - i); //min of RL[mirror] and i~maxRight
            }
            //find len from middle to left and right
            while(i - len >= 0 && i + len < str.length()){
                if(str.charAt(i - len) != str.charAt(i + len)){
                    break;
                }
                len++;
            }
            
            if(len>longest){
                longest = len;
                mid = i;
            }
            
            RL[i] = len;
        }
        
        longest = longest - 1;
        int start = mid / 2 - longest / 2;
                
        return s.substring(start,start+longest);
        
    }
    
    private String generate(String s){
        StringBuilder sb=new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
    
}
