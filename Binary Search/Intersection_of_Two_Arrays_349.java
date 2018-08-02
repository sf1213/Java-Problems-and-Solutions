package Binary_Search;

public class Intersection_of_Two_Arrays_349 {
	//HashSet, O(m+n), 3ms
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> map=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        for(int num:nums1){
            map.add(num);
        }
        for(int num:nums2){
            if(map.remove(num))
                res.add(num);
        }
        int []result=new int[res.size()];
        int i=0;
        for(int num:res){
            result[i++]=num;
        }
        return result;
    }
	
	//Binary Search, O(nlogn+mlogn) , 4ms
	public int[] intersection(int[] nums1, int[] nums2) {        
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums1); //O(nlogn)
        for(int num:nums2){
            if(set.contains(num)) continue;
            if(binarySearch(nums1,num)){
                set.add(num);
            }
        }
        int[]result=new int[set.size()];
        int i=0;
        for(int x:set){
            result[i++]=x;
        }
        return result;
    }
    private boolean binarySearch(int[]nums, int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]) return true;
            else if(target>nums[mid]) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}
