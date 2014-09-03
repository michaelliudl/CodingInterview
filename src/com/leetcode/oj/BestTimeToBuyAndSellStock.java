package com.leetcode.oj;

/**
 * Created by doliu on 9/2/14.
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		int max = 0, currentMin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			max = Math.max(max, prices[i] - currentMin);
			currentMin = Math.min(currentMin, prices[i]);
		}
		return max;
	}
}
