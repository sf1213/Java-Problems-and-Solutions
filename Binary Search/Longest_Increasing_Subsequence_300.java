package Binary_Search;

public class Longest_Increasing_Subsequence_300 {
	//DP, O(n*n), 16ms
	public int lengthOfLIS(int[] nums) {
        int[] len=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            int localMax=0;  
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    localMax=Math.max(localMax,len[j]); //local
                }
            }
            len[i]=localMax+1;
            max=Math.max(max,len[i]);  //global
        }
        return max;
    }
	
	 //Tails array, Template 1, 2ms
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[]tails=new int[nums.length];
        tails[0]=nums[0];
        int size=1; //Initialize the first element        
        for(int num:nums){
            int low=0,high=size-1;  //0~size-1
            while(low<=high){
                int mid=low+(high-low)/2;
                if(num==tails[mid]){
                    low=mid;
                    break;
                }else if(num>tails[mid]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            tails[low]=num;
            if(low==size) size++;            
        }
        return size;       
    }
    
    //Tails array, Template 2, 2ms
    public int lengthOfLIS(int[] nums) {
        int[]tails=new int[nums.length];
        int size=0;       
        for(int num:nums){
            int low=0,high=size; //0~size
            while(low<high){
                int mid=low+(high-low)/2;               
                if(num>tails[mid]){
                    low=mid+1;
                }else{  //num<=tails[mid]
                    high=mid;
                }
            }
            tails[low]=num;
            if(low==size) size++;
            
        }
        return size;       
    }
    
    //Only use Binary Search in the middle
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] tails=new int[nums.length];
        tails[0]=nums[0];
        int size=1; //initialize the first element
        for(int num:nums){
            if(num<=tails[0]){
                tails[0]=num;
            }else if(num>tails[size-1]){
                tails[size++]=num;                
            }else{ //in the middle, binarysearch
                int pos=findPosition(tails,0,size-1,num);
                tails[pos]=num;
            }
        }
        return size;
    }
    //find replace position
    private int findPosition(int[]nums,int low,int high, int target){
        while(low<=high){
            int mid=low+(high-low);
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
