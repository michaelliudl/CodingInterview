package com.leetcode.oj;

/**
 * Created by doliu on 9/2/14.
 */
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - prices[i - 1];
			if (profit > 0) max += profit;
		}
		return max;
	}
}
