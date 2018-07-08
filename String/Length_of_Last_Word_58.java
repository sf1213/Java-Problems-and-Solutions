package String;

public class Length_of_Last_Word_58 {
	 public int lengthOfLastWord(String s) {
	        String[] result=s.split(" ");
	        return result.length==0? 0: result[result.length-1].length();
	        
	        //return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	    }
}
