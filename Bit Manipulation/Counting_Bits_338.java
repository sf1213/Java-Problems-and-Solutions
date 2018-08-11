package Bit_Manipulation;

public class Counting_Bits_338 {
	public int[] countBits(int num) {
        int[] count=new int[num+1];
        for(int i=1;i<=num;i++){
            //count[i]=count[i/2]+i%2;
            count[i]=count[i>>1]+(i&1);
        }
        return count;
    }
	
	
}
