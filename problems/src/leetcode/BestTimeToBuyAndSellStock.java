package leetcode;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * @author chengyangwu
 *
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices.length == 0) return 0;
        
        int max = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            curMin = (prices[i] < curMin) ? prices[i] : curMin;
            
            max = (prices[i] - curMin > max) ? (prices[i] - curMin) : max;
        }
        
        return max;
    }
}
