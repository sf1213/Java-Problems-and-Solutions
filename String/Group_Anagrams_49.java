package String;

public class Group_Anagrams_49 {
//Arrays.sort
public List<List<String>> groupAnagrams(String[] strs) {
       if(strs==null||strs.length==0) return new LinkedList<List<String>>();
       Map<String, List<String>> map=new HashMap<>();
       for(String str:strs){
       //convert String -> char[]
           char[] ca=str.toCharArray();  
           //sort char[] to make it a proper key, O(mlogm)     
           Arrays.sort(ca); 
           //convert char[] -> String                 
           String keystr=Arrays.toString(ca); 
           //if contains no such key, create new LinkedList
           if(!map.containsKey(keystr))          
               map.put(keystr,new LinkedList<String>());
            //add this String to teh exsiting LinkedList           
            map.get(keystr).add(str);          
        }
        //map.values() returns a Collection view of the values contained in this map
        return new LinkedList<>(map.values()); 
    }

/
}
