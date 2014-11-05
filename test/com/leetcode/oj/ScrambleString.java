package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 10/7/14.
 */
public class ScrambleString {
	// 3-d DP, f[n][i][j] = if strings of length n that start from i in s1 and j in s2 are scramble
	public boolean isScrambleDP(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		int len = s1.length();
		boolean[][][] cache = new boolean[len + 1][len][len];
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				cache[1][i][j] = s1.charAt(i) == s2.charAt(j);
		for (int n = 2; n <= len; n++)
			for (int i = 0; i <= len - n; i++)
				for (int j = 0; j <= len - n; j++)
					for (int k = 1; k <= n; k++) {
						if ((cache[k][i][j] && cache[n - k][i + k][j + k])
								|| (cache[k][i][j + n - k] && cache[n - k][i + k][j])) {
							cache[n][i][j] = true;
							break;
						}
					}
		return cache[len][0][0];
	}

	public boolean isScrambleRecursive(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		return isScramble(s1, s2);
	}

	private boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		if (s1.equals(s2)) return true;
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (!Arrays.equals(c1, c2)) return false;
		for (int i = 1; i < s1.length(); i++) {
			String s1_1 = s1.substring(0, i);
			String s1_2 = s1.substring(i);
			String s2_1 = s2.substring(0, i);
			String s2_2 = s2.substring(i);
			if (isScramble(s1_1, s2_1) && isScramble(s1_2, s2_2))
				return true;
			s2_1 = s2.substring(s2.length() - i);
			s2_2 = s2.substring(0, s2.length() - i);
			if (isScramble(s1_1, s2_1) && isScramble(s1_2, s2_2))
				return true;
		}
		return false;
	}

	public boolean isScrambleBrute(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
		int n = s1.length();
		return isScramble(s1, 0, n - 1, s2, 0, n - 1);
	}

	private boolean isScramble(String s1, int start1, int end1, String s2, int start2, int end2) {
		boolean isEqual = true, isReverse = true;
		for (int i = 0; i <= end1 - start1; i++)
			if (s1.charAt(start1 + i) != s2.charAt(start2 + i)) {
				isEqual = false;
				break;
			}
		if (isEqual) return true;
		for (int i = 0; i <= end1 - start1; i++)
			if (s1.charAt(start1 + i) != s2.charAt(end2 - i)) {
				isReverse = false;
				break;
			}
		if (isReverse) return true;
		for (int i = 0; i < end1 - start1; i++) {
			if ((isScramble(s1, start1, start1 + i, s2, start2, start2 + i)
					&& isScramble(s1, start1 + i + 1, end1, s2, start2 + i + 1, end2))
				|| (isScramble(s1, start1, start1 + i, s2, end2 - i, end2)
					&& isScramble(s1, start1 + i + 1, end1, s2, start2, end2 - i - 1)))
				return true;
		}
		return false;
	}
}
