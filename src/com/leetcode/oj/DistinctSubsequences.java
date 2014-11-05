package com.leetcode.oj;

/**
 * Created by doliu on 10/3/14.
 */
public class DistinctSubsequences {
	// DP
	// f(i,j) = No. distinct subsequences of T(0,j) in S(0,i)
	// if S[i] == T[j], f(i,j) = f(i-1,j-1) + f(i-1,j), either choose S[i] or not
	// else f(i,j) = f(i-1,j), can't choose S[i]
	public int numDistinct(String S, String T) {
		if (S == null || T == null || S.length() < T.length()) return 0;
		int m = S.length(), n = T.length();
		int[][] cache = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			cache[i][0] = 1;
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (S.charAt(i - 1) == T.charAt(j - 1))
					cache[i][j] = cache[i - 1][j - 1] + cache[i - 1][j];
				else
					cache[i][j] = cache[i - 1][j];
		return cache[m][n];
	}

	public int numDistinctOneDCache(String S, String T) {
		if (S == null || T == null || S.length() < T.length()) return 0;
		int m = S.length(), n = T.length();
		int[] cache = new int[n + 1];
		cache[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = n - 1; j >= 0; j--)
				cache[j + 1] += (S.charAt(i) == T.charAt(j)) ? cache[j] : 0;
		return cache[n];
	}
}
