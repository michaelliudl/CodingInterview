package com.careercup.crackingcodinginterview;

/**
 * Created by doliu on 12/14/14.
 */
public class Staircase9_1 {

	// DB
	public int countWaysDP(int n) {
		if (n <= 0) return 0;
		int[] cache = new int[n + 1];
		cache[0] = cache[1] = 1;
		return countWaysDP(n, cache);
	}

	private int countWaysDP(int n, int[] cache) {
		if (n < 0) return 0;
		if (cache[n] > 0) return cache[n];
		cache[n] = countWaysDP(n - 1, cache) + countWaysDP(n - 2, cache) + countWaysDP(n - 3, cache);
		return cache[n];
	}

	// brute, O(3^n)
	public int countWays(int n) {
		if (n < 0) return 0;
		if (n <= 1) return 1;
		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
	}
}
