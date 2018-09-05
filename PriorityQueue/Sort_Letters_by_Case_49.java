package Priority_Queue;

public class Sort_Letters_by_Case_49 {
	 public void sortLetters(char[] chars) {
	        if(chars == null || chars.length == 0){
	            return;
	        }
	        
	        int left = -1, right = chars.length;
	        while(left < right){
	            do{ left++; } while(left < right && Character.isLowerCase(chars[left]));
	            do{ right--; } while(left < right && Character.isUpperCase(chars[right]));
	            
	            if(left < right){
	                swap(chars, left, right);
	            }
	            
	        }
	    }
	    
	    private void swap(char[] chars, int i, int j){
	        char temp = chars[i];
	        chars[i] = chars[j];
	        chars[j] = temp;
	    }
}
