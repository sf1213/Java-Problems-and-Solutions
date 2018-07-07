package Array;

public class Majority_Element_II_299 {
//Moore Voting Algorithm
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new LinkedList<Integer>();
        if(nums==null||nums.length==0) return list;
        int count1=0,count2=0;
        int candidate1=0,candidate2=0;
        for(int num:nums){
            if(num==candidate1){
                count1++;              
            }else if(num==candidate2){
                count2++;
            }else if(count1==0){
                candidate1=num;
                count1=1;
            }else if(count2==0){
                candidate2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }          
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(num==candidate1) count1++;
            else if(num==candidate2) count2++;
        }
        if(count1>nums.length/3) list.add(candidate1);
        if(count2>nums.length/3) list.add(candidate2);
        return list;
}
	// general solution: find all elements that appear more than ⌊ n/k ⌋ times.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new LinkedList<Integer>();
        if(nums==null||nums.length==0) return res;
        int k=3;
        int[] count=new int[k-1]; //at most k-1 candidate
        int[] candidate=new int[k-1];
    
        for(int num:nums){
            boolean check=false;
            //check if any candidate==num
            for(int i=0;i<k-1;i++){
                if(candidate[i]==num){
                    count[i]++;
                    check=true;
                    break;
                }
            }
            if(check) continue;
            //check if any count==0
            for(int i=0;i<k-1;i++){
                if(count[i]==0){
                    candidate[i]=num;
                    count[i]=1;
                    check=true;
                    break;
                }
            }
            if(check) continue;
            //decrease each count
            for(int i=0;i<k-1;i++){
                count[i]--;
            }
        }
        
         //reset all counts to 0   
        Arrays.fill(count,0)  ; 
        //count the number of each candidate
        for(int num:nums){
            for(int i=0;i<k-1;i++){
                if(num==candidate[i]) {
                    count[i]++;
                    break;}
            }
        }
        //check if the number of each candidate>n/k
        for(int i=0;i<k-1;i++){
            if(count[i]>nums.length/k) {
                res.add(candidate[i]);
        }
        }
        return res;
}

}
