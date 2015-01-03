package com.leetcode.oj;

/**
 * Created by doliu on 1/1/15.
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.isEmpty()) return 0;
		String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum * CHAR.length() + CHAR.indexOf(s.charAt(i)) + 1;
		}
		return sum;
	}
}
