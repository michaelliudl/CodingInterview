package com.leetcode.oj;

/**
 * Created by doliu on 9/30/14.
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null) return 0;
		if (word1 == null) return word2.length();
		if (word2 == null) return word1.length();
		int m = word1.length(), n = word2.length();
		int[] cache = new int[n + 1];
		int upperLeft = 0; // for cache[i - 1][j - 1]
		for (int i = 1; i <= n; i++)
			cache[i] = i;
		for (int i = 1; i <= m; i++) {
			upperLeft = cache[0];
			cache[0] = i;
			for (int j = 1; j <= n; j++) {
				int upper = cache[j]; // for cache[i - 1][j]
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					cache[j] = upperLeft;
				else
					cache[j] = 1 + Math.min(upperLeft, Math.min(cache[j], cache[j - 1]));
				upperLeft = upper;
			}
		}
		return cache[n];
	}

	public int minDistanceDP(String word1, String word2) {
		if (word1 == null && word2 == null) return 0;
		if (word1 == null) return word2.length();
		if (word2 == null) return word1.length();
		int m = word1.length(), n = word2.length();
		int[][] cache = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
			cache[i][0] = i;
		for (int i = 1; i <= n; i++)
			cache[0][i] = i;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					cache[i][j] = cache[i - 1][j - 1];
				else {
					int replacing = cache[i - 1][j - 1] + 1; // edit distance of replacing word1[i] with word2[j]
					int addition = cache[i][j - 1] + 1;      // edit distance of appending word2[j] to word1
					int deletion = cache[i - 1][j] + 1;      // edit distance of delete word1[i]
					cache[i][j] = Math.min(replacing, Math.min(addition, deletion));
				}
			}
		}
		return cache[m][n];
	}
}
