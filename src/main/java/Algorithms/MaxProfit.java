package Algorithms;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
 */
public class MaxProfit {
	
	public static void main(String[] args) {
		
		int [] l = {5,3,9,12,14,1};
		
		System.out.println(maxProfit(l));
	}
	
	public static int maxProfit(int [] prices){
		 if(prices==null||prices.length<=1)
		        return 0;
		 
		    int min=prices[0]; // min so far
		    int result=0;
		 
		    for(int i=1; i<prices.length; i++){
		        result = Math.max(result, prices[i]-min);
		        min = Math.min(min, prices[i]);
		    }
		 
		    return result;
	}

}
