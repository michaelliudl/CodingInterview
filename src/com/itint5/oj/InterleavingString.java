package com.itint5.oj;

/**
 * Created by doliu on 12/28/14.
 */
// 交替字符串
public class InterleavingString {
	public boolean isInterleaving(String str1, String str2, String str3) {
		if (str1 == null && str2 == null && str3 == null) return true;
		if (str1 == null || str1.isEmpty()) return str2 != null && str2.equals(str3);
		if (str2 == null || str2.isEmpty()) return str1 != null && str1.equals(str3);
		if (str1.length() + str2.length() != str3.length()) return false;

		// 用动态规划的方法，令dp[i][j]代表s3[0...i+j-1]是否由s1[0...i-1]和s2[0...j-1]的字符组成
		// 如果s1当前字符（即s1[i-1]）等于s3当前字符（即s3[i+j-1]），而且dp[i-1][j]为真，那么可以取s1当前字符而忽略s2的情况，dp[i][j]返回真；
		// 如果s2当前字符等于s3当前字符，并且dp[i][j-1]为真，那么可以取s2而忽略s1的情况，dp[i][j]返回真，其它情况，dp[i][j]返回假
		boolean[][] cache = new boolean[str1.length() + 1][str2.length() + 1];
		cache[0][0] = true;
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if ((i >= 1 && cache[i - 1][j] && str1.charAt(i - 1) == str3.charAt(i + j - 1))
						|| j >= 1 && (cache[i][j - 1]) && str2.charAt(j - 1) == str3.charAt(i + j - 1))
					cache[i][j] = true;
			}
		}
		return cache[str1.length()][str2.length()];
	}
}
