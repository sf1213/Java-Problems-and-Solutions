package String;

public class Word_Pattern_290 {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split("\\s+");
		if (pattern.length() != words.length)
			return false;
		// Only one map is needed, cause
		Map<Object, Integer> index = new HashMap<>();

		// 1. if want to use "!=",i must be initialized as "Integer"
		// because with autoboxing, the"==" between two Integer with same value only
		// valid between -128~127
		// beyond this, "Integer" will point to the same object, while autoboxing each
		// time make "int" point to different object
		// 2. if i is initialized as "int", the safe way is to compare them using
		// Objects.equals(Object a,Object b)
		// why not using Object.equals(Object o)? because Object could be null

		for (int i = 0; i < pattern.length(); i++) {
			if (!Objects.equals(index.put(words[i], i), index.put(pattern.charAt(i), i)))// put the last index met in
																							// the map
				return false;
		}

		// for(Integer i=0;i<pattern.length();i++){
		// -----or put the last index met in the map-----
		// if(index.put(words[i],i)!=index.put(pattern.charAt(i),i))
		// ----or put the first index met in the map-----
		// if(index.putIfAbsent(words[i],i)!=index.putIfAbsent(pattern.charAt(i),i))
		// return false;
		// }

		
		//To avoid overflow
//		int count = 1;
//		for (int i = 0; i < pattern.length(); i++) {
//			if (!Objects.equals(index.get(pattern.charAt(i)), index.get(words[i])))
//				return false;
//
//			if (index.get(pattern.charAt(i)) == null) {
//				index.put(pattern.charAt(i), count);
//				index.put(words[i], count);
//				count++;
//			}
//
//		}
		return true;
	}
}
