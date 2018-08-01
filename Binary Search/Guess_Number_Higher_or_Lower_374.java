package Binary_Search;

public class Guess_Number_Higher_or_Lower_374 {
	//Template 2
	public int guessNumber(int n) {
        int low=1,high=n;
        while(low<high){
            int mid=low+(high-low)/2;
            if(guess(mid)==1){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
	
	//Template 1 or 2
	public int guessNumber(int n) {
        int low=1,high=n;
        while(low<high){
            int mid=low+(high-low)/2;
            if(guess(mid)==0){
                return mid;
            }else if(guess(mid)==1){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
}
