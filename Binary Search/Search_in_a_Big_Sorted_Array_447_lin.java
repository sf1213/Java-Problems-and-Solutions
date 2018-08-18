package Binary_Search;

public class Search_in_a_Big_Sorted_Array_447_lin {
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int index = 1;
   
        while(reader.get(index - 1) < target){
           
            index <<= 1;  //index = index * 2
        }
        
        int start = (index - 1) / 2, end = index - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(target > reader.get(mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        
        if(target == reader.get(start)){
            return start;
        }
        
        return -1;
    }
}
