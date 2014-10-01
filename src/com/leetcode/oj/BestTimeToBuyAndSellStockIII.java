package com.leetcode.oj;

/**
 * Created by doliu on 9/29/14.
 */
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		int n = prices.length, max = 0;
		int[] f = new int[n], g = new int[n];
		for (int low = prices[0], i = 1; i < n; i++) {
			low = Math.min(low, prices[i]);
			f[i] = Math.max(f[i - 1], prices[i] - low);
		}
		for (int high = prices[n - 1], i = n - 2; i >= 0; i--) {
			high = Math.max(high, prices[i]);
			g[i] = Math.max(g[i + 1], high - prices[i]);
		}
		for (int i = 0; i < n; i++) {
			max = Math.max(max, f[i] + g[i]);
		}
		return max;
	}
}
