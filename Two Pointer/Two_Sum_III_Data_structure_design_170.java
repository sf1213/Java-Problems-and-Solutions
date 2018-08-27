package Two_Pointer;

public class Two_Sum_III_Data_structure_design_170 {
	//HashMap
	public class TwoSum {
	    /**
	     * @param number: An integer
	     * @return: nothing
	     */
	    Map<Integer, Integer> map = new HashMap<>();
	    
	    public void add(int number) {
	       map.put(number, map.getOrDefault(number, 0) + 1);
	    }

	    /**
	     * @param value: An integer
	     * @return: Find if there exists any pair of numbers which sum is equal to the value.
	     */
	    public boolean find(int value) {
	        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	            int num1 = entry.getKey(), num2 = value - num1;
	            if(num1 == num2){
	                return entry.getValue() > 1;
	            }
	            
	            if(map.containsKey(num2)){
	                return true;
	            }
	        }
	        
	        return false;
	    }
	}
	
	//Two Pointers
	public class TwoSum {
	    /**
	     * @param number: An integer
	     * @return: nothing
	     */
	    List<Integer> res = new ArrayList<>();
	    
	    public void add(int number) {
	       res.add(number);
	    }

	    /**
	     * @param value: An integer
	     * @return: Find if there exists any pair of numbers which sum is equal to the value.
	     */
	    public boolean find(int value) {
	        Collections.sort(res);
	        
	        int i = 0, j = res.size() - 1;
	        while(i < j){
	            int num = res.get(i) + res.get(j);
	            if(num == value){
	                return true;
	            }else if(num < value){
	                i++;
	            }else{
	                j--;
	            }
	        }
	        return false;
	    }
	}
}
