package Priority_Queue;

public class Merge_Sorted_Array_88 {
	//When nums1 and nums2 are all in nums1, ->
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, i = 0;
        int[] temp = new int[m + n];
        while(index1 < m && index2 < n){
            if(nums1[index1] < nums2[index2]){
                temp[i++] = nums1[index1++];
            }else{
                temp[i++] = nums2[index2++];
            }
        }
        
        while(index1 < m){
            temp[i++] = nums1[index1++];
        }
        while(index2 < n){
            temp[i++] = nums2[index2++];
        }
        
        int j = 0;
        for(int num : temp){
            nums1[j++] = num;
        }
    }
	
	//When nums2 is in a separate array, merge it into nums1, <-
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, i = m + n - 1;
        while(index1 >= 0 && index2 >= 0){
            if(nums1[index1] > nums2[index2]){
                nums1[i--] = nums1[index1--];
            }else{
                nums1[i--] = nums2[index2--];
            }
        }
        
        while(index2 >= 0){
            nums1[i--] = nums2[index2--];
        }
    }
}
