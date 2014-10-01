package com.leetcode.oj;

import java.math.BigInteger;

/**
 * Created by doliu on 9/26/14.
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) return s;
		int n = s.length();
		String longest = s.substring(0, 1);
		for (int i = 0; i < n - 1; i++) {
			String sub = expand(s, i, i);
			if (sub.length() > longest.length())
				longest = sub;
			sub = expand(s, i, i + 1);
			if (sub.length() > longest.length())
				longest = sub;
		}
		return longest;
	}

	private String expand(String s, int i, int j) {
		int n = s.length();
		for (; i >= 0 && j < n; i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				return s.substring(i + 1, j);
			}
		}
		return s.substring(i + 1, j);
	}

	public String longestPalindromeManacher(String s) {
		if (s == null || s.length() <= 1) return s;
		String t = preprocess(s);
		int n = t.length(), center = 0, right = 0;
		int[] p = new int[n];
		for (int i = 1; i < n - 1; i++) {
			int mirror = 2 * center - i; // mirror = center - (i - center)
			p[i] = (right > i) ? Math.min((right - i), p[mirror]) : 0;
			while (t.charAt(i + 1 + p[i]) == t.charAt(i - 1 - p[i]))
				p[i]++;
			if (i + p[i] > right) {
				center = i;
				right = i + p[i];
			}
		}
		int max = 0, centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (p[i] > max) {
				max = p[i];
				centerIndex = i;
			}
		}
		int start = (centerIndex - 1 - max) / 2;
		return s.substring(start, start + max);
	}

	private String preprocess(String s) {
		int n = s.length();
		StringBuilder ret = new StringBuilder("^");
		for (int i = 0; i < n; i++) {
			ret.append("#").append(s.charAt(i));
		}
		ret.append("#$");
		return ret.toString();
	}

	// doesn't work for long strings since exceeding range of long
	// BigInteger time out
	public String longestPalindromeDPBitCache(String s) {
		if (s == null || s.length() <= 1) return s;
		int n = s.length(), maxLen = 1;
		String longestSub = s.substring(0, 1);
//		long[] cache = new long[n];
		BigInteger[] cache = new BigInteger[n];
		for (int i = 0; i < n; i++)
			cache[i] = new BigInteger("0");
		for (int i = 0; i < n; i++) {
//			cache[i] |= 1 << (n - 1 - i);
			cache[i] = cache[i].or(new BigInteger("1").shiftLeft(n - 1 - i));
		}
		for (int i = 0; i < n - 1; i++) {
			boolean isSame = s.charAt(i) == s.charAt(i + 1);
			if (isSame) {
//				cache[i] |= 1 << (n - 1 - (i + 1));
				cache[i] = cache[i].or((new BigInteger("1").shiftLeft(n - 1 - (i + 1))));
				if (maxLen < 2) {
					maxLen = 2;
					longestSub = s.substring(i, i + 2);
				}
			}
		}
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				if (isPalindrome(s, i, i + len - 1, n, cache) && maxLen < len) {
					maxLen = len;
					longestSub = s.substring(i, i + len);
				}
			}
		}
		return longestSub;
	}

	private boolean isPalindrome(String s, int i, int j, int n, BigInteger[] cache) {
//		int subValue = 1 << (n - 1 - (j - 1));
		BigInteger subValue = new BigInteger("1").shiftLeft(n - j);
		if (s.charAt(i) == s.charAt(j) && cache[i + 1].and(subValue).equals(subValue)) {
//			cache[i] |= 1 << (n - 1 - j);
			cache[i] = cache[i].or(new BigInteger("1").shiftLeft(n - 1 - j));
			return true;
		}
		return false;
	}

	public String longestPalindromeDP(String s) {
		if (s == null || s.length() <= 1) return s;
		int n = s.length();
		boolean[][] cache = new boolean[n][n];
		int maxLen = 1;
		String longestSub = s.substring(0, 1);
		for (int i = 0; i < n; i++)
			cache[i][i] = true;
		for (int i = 0; i < n - 1; i++) {
			boolean isSame = s.charAt(i) == s.charAt(i + 1);
			cache[i][i + 1] = isSame;
			if (isSame && maxLen < 2) {
				maxLen = 2;
				longestSub = s.substring(i, i + 2);
			}
		}
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				if (isPalindrome(s, i, i + len - 1, cache) && len > maxLen) {
					maxLen = len;
					longestSub = s.substring(i, i + len);
				}
			}
		}
		return longestSub;
	}

	private boolean isPalindrome(String s, int i, int j, boolean[][] cache) {
		if (s.charAt(i) == s.charAt(j) && cache[i + 1][j - 1]) {
			cache[i][j] = true;
			return true;
		}
		return false;
	}

	public String longestPalindromeBrute(String s) {
		if (s == null || s.length() <= 1) return s;
		int maxLen = 0;
		String longestSub = null;
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				String cur = s.substring(i, j);
				if (isPalindrome(cur) && cur.length() > maxLen) {
					maxLen = cur.length();
					longestSub = cur;
				}
			}
		}
		return longestSub;
	}

	private boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
