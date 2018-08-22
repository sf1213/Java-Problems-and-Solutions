package Two_Pointer;

public class Two_Sum_1 {
	//HashSet 1, 5ms
	public int[] twoSum(int[] nums, int target) {

	       if(nums == null){
	            return null;
	        }   
	        Map<Integer,Integer> map = new HashMap<>(); //num, index
	        int[] res = new int[2];
	        
	        for(int i = 0; i < nums.length; i++){
	            if(map.containsKey(target - nums[i])){
	                res[0] = map.get(target - nums[i]);
	                res[1] = i;
	                return res;
	            }
	            
	            map.put(nums[i], i);
	        }        
	        return null;
	    }
	
	//HashSet 2, 5ms
    public int[] twoSum(int[] nums, int target) {
        if(nums == null){
            return null;
        }   
        Map<Integer,Integer> map = new HashMap<>(); //target - num, index
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            
            map.put(target - nums[i], i);
        }        
        return null;
    }
    
    //Two Pointers, 13ms
    public int[] twoSum(int[] nums, int target) {
        Pair[] number = new Pair[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            number[i] = new Pair(nums[i], i);
        }
        
        //Arrays.sort(number, (a, b) -> (a.getValue() - b.getValue()));
        Arrays.sort(number, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.getValue() - b.getValue();
            }
            
        });
        
        int[] res = new int[2];
        int i = 0, j = number.length - 1;
        while(i < j){
            if(number[i].getValue() + number[j].getValue() == target){
                int t1 = number[i].getIndex();
                int t2 = number[j].getIndex();
                return new int[]{Math.min(t1, t2), Math.max(t1, t2)};
            }
            
            if(number[i].getValue() + number[j].getValue() < target){
                i++;
            }else{
                j--;
            }
        }
        
        return null;
        
        
    }
    
    class Pair{
        private int value;
        private int index;
        
        public Pair(int v, int i){
            this.value = v;
            this.index = i;
        }
        
        public int getIndex(){
            return this.index;
        }
        public int getValue(){
            return this.value;
        }
    } 
    
    
}
