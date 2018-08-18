package Binary_Search;

public class Pow_x_n_50 {
	//Recursion, double x,  14ms
	public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            n = -(n + 1); // -2^31 -> -(-2^31 + 1) = 2^31 - 1
            x = 1/x;
            return x * x * myPow(x * x, n/2);

       }
        
        if(n < 0){           
            n = -n;
            x = 1 / x;         
        }
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
	
	//Or:
		public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            n /= 2;
            x *= x;
       }       
        if(n < 0){           
            n = -n;
            x = 1 / x;         
        }
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
		
		//Or:
		public double myPow(double x, int n) {
	        if(n == 0){
	            return 1;
	        }
	     
	        if(n < 0){                     
	            x = 1 / x;         
	            return (n % 2 == 0) ? myPow(x * x, -(n / 2)) : x * myPow(x * x, -(n / 2));
	        }
	        
	        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	    }
		
	//Recursion, double myPow,12ms
		public double myPow(double x, int n) {
	        if(n == 0){
	            return 1;
	        }
	        
	        double tmp = myPow(x, n / 2);
	        
	        if(n < 0){
	            x = 1 / x;
	            n = -n;
	        }
	       
	        return (n % 2 == 0) ? tmp * tmp : x * tmp * tmp;
	    }
	
	//Iteration, 12ms
	public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double res = 1.0;
        if(n < 0){         
            n = -(n + 1); //avoid overflow when n == MIN_VALUE
            x = 1/x;
            res *= x;
        }
        
        
        while(n > 0){
            if((n & 1) == 1){ //n is odd
                res *= x;
            }
            x *= x;  //x = x^2
            n >>= 1; //n = n / 2
            
        }
        return res;      
    }
}
