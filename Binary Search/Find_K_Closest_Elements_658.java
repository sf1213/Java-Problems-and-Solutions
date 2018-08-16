package Binary_Search;

import java.util.Arrays;

public class Find_K_Closest_Elements_658 {
	//Arrays.binarySearch, 8ms
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return res;
        }
        
        int index = Arrays.binarySearch(arr, x); //if not found, return -(insertion point) - 1
        if(index < 0){
            index = -index - 1;
        }
        
        int start = index -1, end = index;
        while(k-- > 0){
            if(start < 0 || end < arr.length && (arr[end] - x < x - arr[start])){
                end++;
            }else{
                start--;
            }
        }
        
        for(int i = start + 1; i < end; i++){
            res.add(arr[i]);
        }
        
        return res;
    }
	
	//Personal binarySearch, 11ms
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return res;
        }
        
        int index = binarySearch(arr, 0, arr.length - 1, x);
        int start = index -1, end = index;
        while(k-- > 0){
            if(start < 0 || end < arr.length && (arr[end] - x < x - arr[start])){
                end++;
            }else{
                start--;
            }
        }
        
        for(int i = start + 1; i < end; i++){
            res.add(arr[i]);
        }
        
        return res;
    }
    //Stop at 0 0r arr.length - 1 or insertion point
     private int binarySearch(int[] arr, int left, int right, int target){
         if(left == right){
             return left;
         }
        
         int mid = left + (right - left) / 2;
         if(target > arr[mid]){
             return binarySearch(arr, mid + 1, right, target);
         }else{
             return binarySearch(arr, left, mid, target);
         }
     }
     
     
    //Only search 0 ~ n - k, 7ms
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
         List<Integer> res = new ArrayList<>();
         if(arr == null || arr.length == 0){
             return res;
         }
         
         int left = 0, right = arr.length - k;
         while(left < right){ 
             int mid = left + (right - left) / 2;
             if(Math.abs(x - arr[mid + k]) < Math.abs(x - arr[mid])){
                 left = mid + 1;
             }else{
                 right = mid;
             }
         }
         
         for(int i = left; i< left + k; i++){
             res.add(arr[i]);
         }
         return res;
     }
     
}
