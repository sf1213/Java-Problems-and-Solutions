package Binary_Search;

public class Greatest_Common_Divisor_845 {

	public int gcd(int a, int b) {
	        // write your code here
	        int big = Math.max(a,b), small = Math.min(a,b);
	        return commonDiv(big, small);
	    }
	private int commonDiv(int big, int small){
	      if(small == 0){
	          return big;
	      }     
	      return commonDiv(small, big % small);
	}
}
