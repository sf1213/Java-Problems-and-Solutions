package Bit_Manipulation;

public class Sum_of_Two_Integers_371 {
	//iteration, 0ms
    public int getSum(int a, int b) {
        if(a==0) return b;
        if(b==0) return a;
        while(b!=0){
            int carry=a&b; //find the digit when both a and b are 1,1+1
            a=a^b; //add a and b, ignoring the digit that both a and b are 1,0+1 or 1+0
            b=carry<<1; //roll over to the left digit
        }
        return a;
    }
    
  //Recursion, 0ms
    public int getSum(int a, int b) {
        return b==0? a: getSum(a^b,(a&b)<<1);
    }
}
