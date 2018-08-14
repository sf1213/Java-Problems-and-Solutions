package String;

public class Longest_Palindrome_409 {
	//HashSet, 12ms
	public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length(); i++){
            if(!set.remove(s.charAt(i))){ //if contains, remove
                set.add(s.charAt(i));     //else, add
            }
        }
        
        int m = set.size();
        if(m == 0){
            m = 1;
        }
        return s.length() - m +1;
    }
	
	//int[256], 7ms
	public int longestPalindrome(String s) {
        int[] count = new int[256];
        for(int i = 0 ; i < s.length(); i++){
            if(count[s.charAt(i) - 'A'] != 0){
                count[s.charAt(i) - 'A']--;
            }else{
                count[s.charAt(i) - 'A']++;
            }
        }
        
        int size = 0;
        for(int num : count){
            if(num != 0){
                size++;
            }
        }
        size = size == 0 ? 1 : size;
        return s.length() - size + 1;               
    }
	
	//int[52]
	public int longestPalindrome(String s) {
        int[] count = new int[52];
        for(int i = 0; i < s.length(); i++){ //65～90 upper, 97～122 lower
            char c = s.charAt(i);
            if(c >= 97 ){  //lower
                count[26 + c - 'a']++;
            }else{         //upper
                count[c - 'A']++;
            }
        }
        
        int len = 0, oddCount = 0, evenCount = 0;       
        for(int num : count){
            evenCount += (num / 2) * 2; //5->4, 4->4
            oddCount += num % 2;
        }
        len = oddCount > 0 ? evenCount + 1 : evenCount;
        return len;
    }
	
}
