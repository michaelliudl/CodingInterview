package com.leetcode.oj;

/**
 * Created by doliu on 1/1/15.
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n <= 0) return "";
		String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int d = n / CHAR.length(), r = n % CHAR.length();
			if (r == 0) {
				sb.append(CHAR.charAt(CHAR.length() - 1));
				n = d - 1;
			} else {
				sb.append(CHAR.charAt(r - 1));
				n = d;
			}
		}
		return sb.reverse().toString();
	}
}
