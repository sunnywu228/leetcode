package leetcode;

import java.util.ArrayList;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author chengyangwu
 *
 */
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length == 0) return 0;
        ArrayList<Integer> record = new ArrayList<Integer> ();
        
        int curMinEle = prices[0];
        int curMax = 0;
        record.add(curMax);
        for (int i = 1; i < prices.length; i ++) {
            curMax = (prices[i] - curMinEle > curMax) ? (prices[i] - curMinEle) : curMax;
            record.add(curMax);
            curMinEle = (prices[i] < curMinEle) ? prices[i] : curMinEle;
        }
        
        curMax = 0;
        int curMaxEle = prices[prices.length - 1];
        int result = 0;
        for (int i = prices.length - 2; i > 0; i --) {
            curMax = (curMaxEle - prices[i] > curMax) ? (curMaxEle - prices[i]) : curMax;
            curMaxEle = (prices[i] > curMaxEle) ? prices[i] : curMaxEle;
            result = (curMax + record.get(i - 1) > result) ? (curMax + record.get(i - 1)) : result;
        }
        return Math.max(result, record.get(prices.length - 1));
    }
}
