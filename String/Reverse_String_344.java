package String;

public class Reverse_String_344 {
	//Iterative Swapping Using Two Pointers, tocharArray() temp reverse
	 public String reverseString(String s) {
		 if(s==null) return null;
	        int i=0;
	        int j=s.length()-1;
	        char[] c=s.toCharArray();
	        while(i<j){
	            char temp=c[j];
	            c[j]=c[i];
	            c[i]=temp;
	            i++;
	            j--;            
	        }
	        return new String(c);
	    }
	 //Iterative Swapping Using Two Pointers, XOR
	 public String reverseString(String s) {
	        if(s==null) return null;
	        int i=0;
	        int j=s.length()-1;
	        char[] c=s.toCharArray();
	        while(i<j){
	            c[i]^=c[j];
	            c[j]^=c[i];
	            c[i]^=c[j];
	            i++;
	            j--;            
	        }
	        return new String(c);
	    }
	 
	 //StringBuilder
	 public String reverseString(String s) {
	        if(s==null) return null;
	        return new StringBuilder(s).reverse().toString();
	    }
	 //Divide and conquer recursion
	 public String reverseString(String s) {
	        if(s==null) return null;
	        int length=s.length();
	        if(length<=1) return s;
	        String left=s.substring(0,length/2);
	        String right=s.substring(length/2,length);
	        return reverseString(right)+reverseString(left);
	    }
}
