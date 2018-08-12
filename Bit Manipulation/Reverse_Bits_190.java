package Bit_Manipulation;

public class Reverse_Bits_190 {
	//Straightforward , 1ms
	public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<31;i++){
            result+=n&1;
            n>>>=1; //unsigned shift
            result<<=1;
        }
        return result+(n&1); //last digit don't shift left
    }
	
	//Integer.reverse(n) source code
	public int reverseBits(int n) {
        int res = n;
        res = (res>>>16) | (res<<16); //16 bit
        res = ((res & 0xff00ff00)>>>8) | ((res & 0x00ff00ff)<<8); //8 bit
        res = ((res & 0xf0f0f0f0)>>>4) | ((res & 0x0f0f0f0f)<<4); //4 bit
        res = ((res & 0xcccccccc)>>>2) | ((res & 0x33333333)<<2); //4 bit c:1100,3:0011
        res = ((res & 0xaaaaaaaa)>>>1) | ((res & 0x55555555)<<1); //4 bit a:1010,5:0101
        return res;
    }
}
