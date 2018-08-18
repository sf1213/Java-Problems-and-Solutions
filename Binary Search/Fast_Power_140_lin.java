package Binary_Search;

public class Fast_Power_140_lin {
	//Recursion
	public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0){
            return 1 % b;
        }
        
        long tmp = fastPower(a, b, n / 2);
        return n % 2 == 0?  (int)((tmp * tmp) % b) : (int)(((tmp * tmp) % b * (a % b)) % b);
                
        // long product = fastPower(a, b, n / 2);
        // product = (product * product) % b;
        // if (n % 2 == 1) {
        //     product = (product * (a % b)) % b;
        // }
        // return (int) product;
    }
	
	//Iteration
	public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0){
            return 1 % b;
        }
        long res = 1, tmp = a;
        while(n > 0){
            if((n & 1 ) == 1){
                res = (res * tmp) % b;
            }
            
            tmp = (tmp * tmp) % b;
            n /= 2;
        }
        
        return (int)res;
    }
}
