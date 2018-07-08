package String;

public class First_Unique_Character_in_a_String_387 {
	//Two Pass, array[256]
	public int firstUniqChar(String s) {
        int[] map=new int[256];   //if the string contains any characters which are represented by ASCII, better use int[256]
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-' ']++;  //considering space is the 32th on ASCII table.
        }
        
        for(int i=0;i<s.length();i++){
            if(map[s.charAt(i)-' ']==1) 
                return i;
        }
        return -1;
    }
	
	//One Pass, with LinkedHashMap
	public int firstUniqChar(String s) {
        Map<Character,Integer> map=new LinkedHashMap<>();//LinkedHashMap to keep the order
        Set<Character> set=new HashSet<>();     //HashSet to record the character
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                if(map.get(s.charAt(i))!=null){
                    map.remove(s.charAt(i));
                }
            }else{
                set.add(s.charAt(i));
                map.put(s.charAt(i),i);  //key:character, value:index
            }
        }
        
        return map.size()==0? -1:map.entrySet().iterator().next().getValue();
    }
}
