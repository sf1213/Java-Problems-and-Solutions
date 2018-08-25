package Two_Pointer;

public class Two_Sum_Difference_equals_to_target_610_Lin {
	//Two Pointers
	public int[] twoSum7(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{};
        }
        
        Pair[] copy = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            copy[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(copy, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.getValue() - b.getValue();
            }
            });
        target = Math.abs(target);
        
        int j = 1;
        for(int i = 0; i < copy.length; i++){
            if(i == j){
                j++;
            }
            while(j < copy.length && copy[j].getValue() - copy[i].getValue() < target){
                j++;
            }
            
            if(copy[j].getValue() - copy[i].getValue() == target){
                int t1 = copy[i].getIndex() + 1;
                int t2 = copy[j].getIndex() + 1;
                return new int[]{Math.min(t1, t2), Math.max(t1, t2)};
            }
        }
        
        return null;
    }
}
class Pair{
    private int value;
    private int index;
    
    public Pair(int v, int i){
        this.value = v;
        this.index = i;
    }
    
    public int getValue(){
        return this.value;
    }
    
      public int getIndex(){
        return this.index;
    }
}


//Two Pointers2
public int[] twoSum7(int[] nums, int target) {
    int[] res = new int[2];
    if(nums == null || nums.length == 0){
        return null;
    }
    int[] copy = Arrays.copyOf(nums,nums.length);
    
    Arrays.sort(copy);
    target = Math.abs(target);
    
    int[] value = new int[2];
    
    int j = 1;
    for(int i = 0; i < copy.length; i++){
        if(i == j){
            j++;
        }
        while(j < copy.length && copy[j] - copy[i] < target){
            j++;
        }
        
        if(copy[j] - copy[i] == target){
            value[0] = copy[j];
            value[1] = copy[i];

            break;
        }
    }
    
    int index = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == value[0] || nums[i] == value[1]){
            res[index++] = i + 1;
        }
    }
    
    return res;
}

//HashMap
public int[] twoSum7(int[] nums, int target) {
    int[] res = new int[2];
    if(nums == null || nums.length == 0){
        return res;
    }
    
    Map<Integer, Integer> map = new HashMap<>();
    
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i] + target)){
            res[0] = map.get(nums[i] + target) + 1;
            res[1] = i + 1;
            return res;
        }
        
        if(map.containsKey(nums[i] - target)){
            res[0] = map.get(nums[i] - target) + 1;
            res[1] = i + 1;
            return res;
        }
        
        map.put(nums[i], i);
    }
    
    return res;
}
}
