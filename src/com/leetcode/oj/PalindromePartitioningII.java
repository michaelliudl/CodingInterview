package com.leetcode.oj;

/**
 * Created by doliu on 10/3/14.
 */
public class PalindromePartitioningII {
	public int minCutIterative(String s) {
		if (s == null || s.length() <= 1) return 0;
		int n = s.length();
		int[] cut = new int[n + 1];
		boolean[][] palin = new boolean[n][n];
		for (int i = 0; i <= n; i++)
			cut[i] = n - 1 - i;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || palin[i + 1][j - 1])) {
					palin[i][j] = true;
					cut[i] = Math.min(cut[i], cut[j + 1] + 1);
				}
			}
		}
		return cut[0];
	}

	public int minCutRecursive(String s) {
		if (s == null || s.length() <= 1) return 0;
		int n = s.length();
		int[] cut = new int[n];
		for (int i = 0; i < n; i++)
			cut[i] = -1;
		boolean[][] palin = isPalindrom(s);
		minCut(s, 0, n, cut, palin);
		return cut[0];
	}

	private int minCut(String s, int start, int len, int[] cut, boolean[][] palin) {
		if (start >= len) return 0;
		if (cut[start] >= 0) return cut[start];
		int min = Integer.MAX_VALUE;
		for (int i = start; i < len; i++) {
			if (palin[start][i]) {
				int val = minCut(s, start + 1, len, cut, palin);
				min = Math.min(min, val);
			}
		}
		cut[start] = min;
		return min;
	}

	private boolean[][] isPalindrom(String s) {
		boolean[][] result = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				int start = i, end = j;
				boolean isPalin = true;
				while (start <= end) {
					if (result[start][end])
						break;
					if (s.charAt(start) != s.charAt(end)) {
						isPalin = false;
						break;
					}
					start++;
					end--;
				}
				result[i][j] = isPalin;
			}
		}
		return result;
	}

	public int minCutTimeout(String s) {
		if (s == null || s.length() <= 1) return 0;
		int n = s.length();
		boolean[][] palin = new boolean[n][n];
		int[][] cut = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				cut[i][j] = j - i;
		for (int i = 0; i < n; i++) {
			palin[i][i] = true;
			cut[i][i] = 0;
			if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				palin[i][i + 1] = true;
				cut[i][i + 1] = 0;
			}
		}
		for (int len = 3; len <= n; len++) { // loop all substrings length 3 to n
			for (int start = 0; start <= n - len; start++) { // all possible start index of length
				int end = start + len - 1;
				if (s.charAt(start) == s.charAt(end) && palin[start + 1][end - 1])
					palin[start][end] = true;
				if (palin[start][end])
					cut[start][end] = 0;
				else
					for (int i = start; i < end; i++)
						cut[start][end] = Math.min(cut[start][end], cut[start][i] + 1 + cut[i + 1][end]);
			}
		}
		return cut[0][n - 1];
	}
}
