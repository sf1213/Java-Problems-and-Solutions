package String;

public class Longest_Palindromic_Subsequence_516 {
	//DP 1, 33ms
	public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        
        int n = s.length();
        int[][] Pali = new int[n][n];
        int longest = 1;
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                char left = s.charAt(i);
                char right = s.charAt(j);
                if(i == j){
                    Pali[i][j] = 1;
                }else if(i + 1 == j){
                    Pali[i][j] = left == right ? 2 : 1;
                }else{
                    if(left == right){
                        Pali[i][j] = 2 + Pali[i + 1][j - 1];
                    }else{
                        Pali[i][j] = Math.max(Pali[i + 1][j] , Pali[i][j - 1]);
                    }                    
                }
                
                if(Pali[i][j] > longest){
                    longest = Pali[i][j];
                }
            }
        }
        return longest;
    }
	
	//DP 2, fast and concise, 29ms
	public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        
        int n = s.length();
        int[][] Pali = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            Pali[i][i] = 1;
            for(int j = i + 1; j < n; j++){            
                if(s.charAt(i) == s.charAt(j)){
                    Pali[i][j] = 2 + Pali[i + 1][j - 1];
                }else{
                    Pali[i][j] = Math.max(Pali[i + 1][j] , Pali[i][j - 1]);
                }                          
            }
        }
        return Pali[0][n - 1];
    }
	
	//Recursion, 22ms
	public int longestPalindromeSubseq(String s) {
        if(s == null){
            return 0;
        }
        int[][] Pali = new int[s.length()][s.length()];
        return helper(s, Pali, 0, s.length() - 1);
    }
    
    private int helper(String s, int[][] Pali, int i, int j){
        if(Pali[i][j] != 0){   //avoid duplicate calculation
            return Pali[i][j];
        }
        
        if(i > j){
            Pali[i][j] = 0;
        }else if(i == j){
            Pali[i][j] = 1;           
        }else{
            if(s.charAt(i) == s.charAt(j)){
                Pali[i][j] = 2 + helper(s, Pali, i + 1, j -1);
                
            }else{
                Pali[i][j] =  Math.max(helper(s, Pali, i, j - 1), helper(s, Pali, i + 1, j));
                
            }       
        }
        return Pali[i][j];    
    }
}
