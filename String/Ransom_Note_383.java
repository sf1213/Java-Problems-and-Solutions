package String;

public class Ransom_Note_383 {
	//charAt(i)-' ' , 13ms
public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] count=new int[256];
        for(int i=0;i<magazine.length();i++){
            count[magazine.charAt(i)-' ']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(count[ransomNote.charAt(i)-' ']--==0)
                return false;
        }
        return true;
        
    }
//toCharArray 9ms
public boolean canConstruct(String ransomNote, String magazine) {
    
    int[] count=new int[256];
    for(char c:magazine.toCharArray()){
        count[c]++;
    }
    for(char c:ransomNote.toCharArray()){
        if(count[c]--==0)
            return false;
    }
    return true;
    
}
//Hashmap 35ms
public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character,Integer> map=new HashMap<>();
     
     for(int i=0;i<magazine.length();i++){
         char c=magazine.charAt(i);
         map.put(c,map.getOrDefault(c,0)+1);
     }
     for(int i=0;i<ransomNote.length();i++){
         char c=ransomNote.charAt(i);
         map.put(c,map.getOrDefault(c,0)-1);
         if(map.get(c)<0)
             return false;
     }
     return true;
     
 }
}


