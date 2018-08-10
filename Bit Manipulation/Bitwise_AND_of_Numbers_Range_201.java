package Bit_Manipulation;

public class Bitwise_AND_of_Numbers_Range_201 {
	public int rangeBitwiseAnd(int m, int n) {
        int i=0;//how many 0 are on the rihgt
        while(m!=n){
            i++;
            m>>=1; //move right
            n>>=1;
        }
        return m<<i; //move left
    }
	
	//or
public int rangeBitwiseAnd(int m, int n) {       
        while(m<n){
            n=n&(n-1);
        }
        return n; 
    }
}
