package com.leetcode.oj;

/**
 * Created by doliu on 9/8/14.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) return true;
		int i = 0, j = s.length() - 1;
		String lower = s.toLowerCase();
		while (i <= j) {
			if (isAlphaNumeric(lower.charAt(i)) && isAlphaNumeric(lower.charAt(j))) {
				if (lower.charAt(i) != lower.charAt(j)) return false;
				i++;
				j--;
			} else {
				if (!isAlphaNumeric(lower.charAt(i))) i++;
				if (!isAlphaNumeric(lower.charAt(j))) j--;
			}
		}
		return true;
	}

	private boolean isAlphaNumeric(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}
}
