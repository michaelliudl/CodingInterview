package com.leetcode.oj;

/**
 * Created by doliu on 9/8/14.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		int n = x;
		if (n == 0) return true;
		if (n < 0) return false;
		int d = 1, m = n;
		while (m >= 10) {
			d *= 10;
			m /= 10;
		}
		m = n;
		while (m > 0) {
			int last = m % 10;
			int first = m / d;
			if (first != last) return false;
			m %= d;
			m /= 10;
			d /= 100;
		}
		return true;
	}
}
