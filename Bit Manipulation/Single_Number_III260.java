package LeetCode;

public class Single_Number_III260 {
	public int[] singleNumber(int[] nums) {
        int[] arr={0,0};
        int diff=0;
        for(int num:nums){
            diff^=num;
        }
        
        diff &=-diff;//1 in diff means two single no. has different no. at this position, diff&=-diff will leave the rightmost 1 and others 0
        for(int num:nums){
            if((num & diff)==0){
                arr[0]^=num;
            }else{
                arr[1]^=num;
            }
        }
        return arr;
    }

}
