package Binary_Search;

public class Intersection_of_Two_Arrays_II_350 {
	//HashMap, O(m+n), 5ms
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if(map.containsKey(num)&&map.get(num)>0){
                res.add(num);
                map.put(num,map.get(num)-1);
            }
                
        }
        int[]result=new int[res.size()];
        int i=0;
        for(int n:res){
            result[i++]=n;
        }
        return result;
    }
	
	//Two Pointers, Arrays.sort, O(nlogn+mlogm), 2ms
	public int[] intersect(int[] nums1, int[] nums2) {     
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums1);  //O(nlogn)
        Arrays.sort(nums2);  //O(mlogm)
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{   //nums1[i]==nums2[j];
                res.add(nums1[i]);
                i++;
                j++;               
            }
        }
        int[]result=new int[res.size()];
        int x=0;
        for(int n:res){
            result[x++]=n;
        }
        return result;
    }
}
