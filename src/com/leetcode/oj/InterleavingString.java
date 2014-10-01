package com.leetcode.oj;

/**
 * Created by doliu on 9/30/14.
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) return false;
		if (s3.length() != s1.length() + s2.length()) return false;
		int m = s1.length(), n = s2.length(), k = s3.length();
		boolean[] cache = new boolean[n + 1];
		cache[0] = true;
		for (int i = 1; i <= n; i++)
			cache[i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && cache[i - 1];
		for (int i = 1; i <= m; i++) {
			cache[0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && cache[0];
			for (int j = 1; j <= n; j++)
				cache[j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && cache[j])
						||
						((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && cache[j - 1]);
		}
		return cache[n];
	}

	public boolean isInterleaveDP(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) return false;
		if (s3.length() != s1.length() + s2.length()) return false;
		int m = s1.length(), n = s2.length(), k = s3.length();
		boolean[][] cache = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				cache[i][j] = true;
		for (int i = 1; i <= m; i++)
			cache[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && cache[i - 1][0];
		for (int i = 1; i <= n; i++)
			cache[0][i] = (s2.charAt(i - 1) == s3.charAt(i - 1)) && cache[0][i - 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				cache[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && cache[i - 1][j])
						||
						((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && cache[i][j - 1]);
			}
		}
		return cache[m][n];
	}

	public boolean isInterleaveBrute(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) return false;
		if (s3.length() != s1.length() + s2.length()) return false;
		int m = s1.length(), n = s2.length(), k = s3.length();
		return isInterleave(s1, 0, m, s2, 0, n, s3, 0, k);
	}

	private boolean isInterleave(String s1, int first1, int last1, String s2, int first2, int last2, String s3, int first3, int last3) {
		if (first3 == last3)
			return first1 == last1 && first2 == last2;
		return (last1 > first1 && s1.charAt(first1) == s3.charAt(first3) && isInterleave(s1, first1 + 1, last1, s2, first2, last2, s3, first3 + 1, last3))
			|| (last2 > first2 && s2.charAt(first2) == s3.charAt(first3) && isInterleave(s1, first1, last1, s2, first2 + 1, last2, s3, first3 + 1, last3));
	}
}
