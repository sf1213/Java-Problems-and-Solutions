package String;

public class Valid_Anagram_242 {
	//array[26]
	public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[]a=new int[26];
        for(int i=0;i<s.length();i++) {
            a[s.charAt(i)-'a']++;
            a[t.charAt(i)-'a']--;
        }
        
        
        for(int num:a){
            if(num!=0) return false;
        }
        return true;
    }
	
	//Hashmap
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> mymap=new HashMap<>();
        for(char c:s.toCharArray()){
            mymap.put(c,mymap.getOrDefault(c,0)+1);
        }
        
        for(char c:t.toCharArray()){
            mymap.put(c,mymap.getOrDefault(c,0)-1);
            if(mymap.get(c)<0) return false;
        }
        return true;
    }
    
  //follow up: contain unicode characters 
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Integer,Integer> mymap=new HashMap<>();
        int index=0;
        while(index<s.length()){
            int code=s.codePointAt(index);
            mymap.put(code,mymap.getOrDefault(code,0)+1);
            index+=Character.charCount(code);
        }
        index=0;
        while(index<t.length()){
            int code=t.codePointAt(index);
            mymap.put(code,mymap.getOrDefault(code,0)-1);
            if(mymap.get(code)<0) return false;
            index+=Character.charCount(code);
        }
        return true;
    }
}
