package Array;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
	public int maxProfit(int[] prices) {
        //greedy
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]) profit+=prices[i+1]-prices[i];
        }
        return profit;
    }
	
	public int maxProfit(int[] prices) {
        //not so greed, find local minimum and maximum, not allowed to buy and sell stocks within the same day 
        int profit=0;
        int l=prices.length;
        for(int i=0;i<l;i++){
            //find local min
            while(i<l-1&&prices[i+1]<=prices[i]) i++;
            int min=prices[i++];
            //find local max
            while(i<l-1&&prices[i+1]>=prices[i]) i++;            
            profit+= i<l? prices[i]-min:0;
        }
        return profit;
    }
}
