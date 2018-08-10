package Bit_Manipulation;

public class Find_the_Difference_389 {
	//Bit manipulation

	public char findTheDifference(String s, String t) {
	    char result=0;
	    for(int i=0;i<s.length();i++){
	        result^=s.charAt(i);
	    }
	    for(int i=0;i<t.length();i++){
	        result^=t.charAt(i);
	    }
	    return result;
	}
	
	//Or
    public char findTheDifference(String s, String t) {
        char result=0;
        for(int i=0;i<s.length();i++){
            result^=t.charAt(i);
            result^=s.charAt(i);
        }
        result^=t.charAt(t.length()-1);
        return result;
    }

    //Array[26]

    public char findTheDifference(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            if(--arr[t.charAt(i)-'a']<0)
                return t.charAt(i);                
        }
        return '0';
    }
}
