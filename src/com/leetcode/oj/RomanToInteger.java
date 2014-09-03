package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 8/26/14.
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) return 0;
		Map<String, Integer> letterToDigit = new HashMap<>();
		letterToDigit.put("M", 1000);
		letterToDigit.put("D", 500);
		letterToDigit.put("C", 100);
		letterToDigit.put("L", 50);
		letterToDigit.put("X", 10);
		letterToDigit.put("V", 5);
		letterToDigit.put("I", 1);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			int cur = letterToDigit.get(c);
			result += cur;
			if (i > 0) {
				String prevC = String.valueOf(s.charAt(i - 1));
				int prev = letterToDigit.get(prevC);
				if (prev < cur) result -= 2 * prev;
			}
		}
		return result;
	}
}
