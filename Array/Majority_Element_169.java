package Array;

public class Majority_Element_169 {
	//Sorting
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	//Hashmap
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> counts=new HashMap<>();
        int result=0;
        for(int num:nums){
            //if this map contains no mapping for the key num, put default value 0+1; if num is mapped, put old value+1
            counts.put(num,counts.getOrDefault(num,0)+1);
            
            if(counts.get(num)>nums.length/2){
                result=num;
            }
        }
        return result;
    }
    
  //Divide and Conquer
    public int majorityElement(int[] nums) {
        return majority(nums,0,nums.length-1);
    }
    //recursively find the majority in left part, then recuesively find majority in right part
    //if left==right, return left, otherwise, linear scan the array,return the one with larger count
    private int majority(int[] nums, int low, int high){
        if(low==high) return nums[low];
        
        int mid=low+(high-low)/2;
        int left=majority(nums,low,mid);
        int right=majority(nums,mid+1,high);
        
        if(left==right) return left;
        return count(nums,left)>count(nums,right)? left:right;
    }
    
    private int count(int[] nums, int candidate){
        int result=0;
        for(int num:nums){
            if(num==candidate) result++;
        }
        return result;
    }
    
  //Randomization
    public int majorityElement(int[] nums) {
        Random rand=new Random();
        
        while(true){
            int candidate=nums[rand.nextInt(nums.length)]; //index=random num 0~nums.length
            int count=0;
            for(int num:nums){
                if(num==candidate) count++;
            }
            if(count>nums.length/2) return candidate;
        }
    }
    
  //bit manipulation 1
    public int majorityElement(int[] nums) {
        int[] bit=new int[32];
        int result=0;
        for(int num:nums){
            for(int i=0;i<32;i++){
                if((num>>(31-i)&1)==1) bit[i]++;
            }
        }
        
        for(int i=0;i<32;i++){
            bit[i]=bit[i]>nums.length/2? 1:0;
            result+=bit[i]<<(31-i);
        }
        return result;
    }
    //bit manipulation 2,use mask to count number of 1    
public int majorityElement(int[] nums) {
        
        int mask=1;
        int result=0;
        for(int i=0;i<32;i++){
            int count=0;
            
            for(int num:nums){
                if((num&mask)!=0) count++;//count the number of 1's on a specific bit
                if(count>nums.length/2) {
                    result=result|mask;
                   break;
                }
            }
            mask=mask<<1;
            
        }
        return result;
    }
    
//Moore Voting Algorithm
public int majorityElement(int[] nums) {
    int result=0,count=0;
    for(int num:nums){
        if(count==0) result=num;
        
        count+=(result==num)? 1:-1;
    }
    return result;
}
}
