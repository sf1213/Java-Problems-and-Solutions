package String;

public class Reverse_Vowels_of_a_String_345 {
	//Two pointer iteration -String  3ms
	public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        String vowels="aeiouAEIOU";
        int i=0;
        int j=s.length()-1;
        while(i<j){
           while(i<j&&vowels.indexOf(chars[i])==-1) 
                 i++;                        
           while(i<j&&vowels.indexOf(chars[j])==-1)
                j--;
           char temp=chars[i];
           chars[i++]=chars[j];
           chars[j--]=temp;                        
        }
        return new String(chars);
    }
	
	//Two pointer iteration -HashSet  7ms
	public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
       Set<Character> vowels=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int i=0;
        int j=s.length()-1;
        while(i<j){
           while(i<j&&!vowels.contains(chars[i])) 
                 i++;                        
           while(i<j&&!vowels.contains(chars[j]))
                j--;
           char temp=chars[i];
           chars[i++]=chars[j];
           chars[j--]=temp;                        
        }
        return new String(chars);
    }
	//Two pointer iteration-boolean array[256]  2ms
	public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
       boolean[] vowels=new boolean[256];
        vowels['a'] = true;
        vowels['o'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['O'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['U'] = true;
        int i=0;
        int j=s.length()-1;
        while(i<j){
           while(i<j&&!vowels[chars[i]]) 
                 i++;                        
           while(i<j&&!vowels[chars[j]])
                j--;
           char temp=chars[i];
           chars[i++]=chars[j];
           chars[j--]=temp;                        
        }
        return new String(chars);
    }
}
