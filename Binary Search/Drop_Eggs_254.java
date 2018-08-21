package Binary_Search;

public class Drop_Eggs_254 {
	public int dropEggs(int n) {
        int x = 0;
        long sum = 0; //n = 2^31 - 1
        while(sum < n){
            ++x;
            sum += x;
        }        
        return x;
    }
}
