package String;

public class Valid_Palindrome_125 {
	public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        
        int left = 0, right = s.length() - 1;
        while(left < right){
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);
            if(!Character.isLetterOrDigit(lChar)){
                left++;
            }else if(!Character.isLetterOrDigit(rChar)){
                right--;
            }else{
                if(Character.toLowerCase(lChar) != Character.toLowerCase(rChar)){
                    return false;
                }
            
                left++;
                right--;
            }            
        }         
        return true;    
    }
}
