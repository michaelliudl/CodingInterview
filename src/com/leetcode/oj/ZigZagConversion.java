package com.leetcode.oj;

/**
 * Created by doliu on 9/17/14.
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0 || nRows < 2) return s;
		int countInGroup = 2 * (nRows - 1);
		int groupCount = s.length() / countInGroup + 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < groupCount; j++) {
				int pos = i + j * countInGroup;
				if (pos < s.length()) sb.append(s.charAt(pos));
				if (i > 0 && i < nRows - 1) {
					pos = countInGroup - i + j * countInGroup;
					if (pos < s.length()) sb.append(s.charAt(pos));
				}
			}
		}
		return sb.toString();
	}
}
