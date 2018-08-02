package Binary_Search;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {
	//Time O(n), 4ms
	public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int low=0,high=nums.length-1;
        int position=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                position=mid;
                break;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{             //nums[mid]<target
                low=mid+1;
            }
        }
        if(position==-1) return new int[]{-1,-1};
        int i=position,j=position;
        while(i<nums.length-1&&nums[i+1]==nums[position]) i++;
        while(j>0&&nums[j-1]==nums[position]) j--;
        return new int[]{j,i};
    }
	
	//Two Binary Seaach, O(logn), 4ms
	public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int[]range=new int[2];
        int low=0,high=nums.length-1;        
        //find left        
        while(low<high){
            int mid=low+(high-low)/2; //move toward left
            if(target>nums[mid]) low=mid+1;
            else high=mid; //target<=nums[mid]                
        }
        if(nums[low]!=target) return new int[]{-1,-1};
        else range[0]=low;
        high=nums.length-1; //low not change
        //find right
        while(low<high){ 
            int mid=low+(high-low)/2+1; //move toward right
            if(target<nums[mid]) high=mid-1;
            else low=mid;    //target>=nums[mid] 
        }
        range[1]=low;
        return range;
    }
	
	//One Binary Search, O(logn), 4ms
	public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int left=findLeft(nums,target);
        if(left==nums.length||nums[left]!=target) return new int[]{-1,-1};
        return new int[]{left,findLeft(nums,target+1)-1};        
    }
    
    //find left, low will stop at: 0/high(not found)/target/target position+1(not found)
    private int findLeft(int[]nums,int target){
        int low=0,high=nums.length; //for case like nums=[1],find 1
        while(low<high){
            int mid=low+(high-low)/2;
            if(target>nums[mid]) low=mid+1;
            else high=mid;
        }
        return low;
    }
	
}
