package Bit_Manipulation;

public class Number_of_1_Bits_191 {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num=0;
        while(n!=0){
            num+=n&1;
            n>>>=1; // unsigned shift
        }
        return num;
    }
    
    public int hammingWeight(int n) {
        int num=0;
        for(int i=0;i<32;i++){
            num+=n&1;
            n>>=1; 
        }
        return num;
    }
    
    public int hammingWeight(int n) {
        int num=0;
        while(n!=0){
            num++;
            n=n&(n-1); //each time turn the rightmost 1 to 0
        }
        return num;
    }
}
