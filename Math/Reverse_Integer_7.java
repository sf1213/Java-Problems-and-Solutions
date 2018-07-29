package Math;

public class Reverse_Integer_7 {
	//Set sum as long type, but this is undesirable
	public int reverse(int x) {        
        long sum=0;
        for(int i=x;i!=0;i=i/10){
            sum=sum*10+i%10;
            if(sum>Integer.MAX_VALUE||sum<Integer.MIN_VALUE)
                return 0;
        }
        return (int)sum;
    }
	//Keep sum as int
	 public int reverse(int x) {        
	        int result=0,sum=0,digit=0;
	        for(int i=x;i!=0;i=i/10){
	            digit=i%10;
	            result=sum*10+digit;
	            if((result-digit)/10!=sum) //check overflow
	                return 0;
	            sum=result;
	        }
	        return sum;
	    }
}
