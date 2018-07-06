package Array;

public class Gas_Station_134 {
	//slow method, iterate every num from beginning to end
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;    
        for(int i=0;i<gas.length;i++){
            sum=0;
          int j=i;
            int l=gas.length;
            while(l-->0){
                j=j>gas.length-1?j-gas.length:j;  
                sum+=gas[j]-cost[j];
                if(sum<0) break;
                j++;
        }           
            if(sum>=0) return i;
    }
        return -1;
}
	//clever way
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance=0;
        int tank=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i]; 
            if(tank<0){
                start=i+1;  //if exist, start must be after this station
                balance+=tank; //record the previous negative tank
                tank=0;  //reset tank
            }
        }
        return balance+tank>=0?start:-1;
    }
}
