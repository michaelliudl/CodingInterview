package com.leetcode.oj;

/**
 * Created by doliu on 10/9/14.
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
		int prev = 0, cur = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0')
				cur = 0;
			if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
				prev = 0;
			int temp = cur;
			cur = cur + prev;
			prev = temp;
		}
		return cur;
	}

	public int numDecodingsDP(String s) {
		if (s == null || s.length() == 0) return 0;
		int[] cache = new int[s.length() + 1];
		cache[0] = 0;
		cache[1] = s.charAt(0) > '0' && s.charAt(0) <= '9' ? 1 : 0;
		if (cache[1] == 0) return 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '9')
				cache[i] += cache[i - 1];
			if ((s.charAt(i - 2) == '1' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')
					|| (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'))
				cache[i] += i - 2 == 0 && cache[i - 2] == 0 ? 1 : cache[i - 2];
		}
		return cache[s.length()];
	}
}
