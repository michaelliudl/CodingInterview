package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 10/6/14.
 */
public class StringToInteger {
	public int atoi(String str) {
		if (str == null) throw new NullPointerException();
		String s = str.trim();
		if (s.length() == 0) return 0;
		boolean isPositive = true, hasSign = false;
		int start = 0;
		if (s.charAt(0) == '+') {
			hasSign = true;
			start = 1;
		} else if (s.charAt(0) == '-') {
			hasSign = true;
			start = 1;
			isPositive = false;
		}
		List<Integer> numbers = new ArrayList<>();
		for (int i = start; i < s.length(); i++) {
			if (hasSign && numbers.isEmpty() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
				return 0;
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
				numbers.add(Character.getNumericValue(s.charAt(i)));
			else
				break;
		}
		if (numbers.size() > 0) {
			long result = 0;
			for (int i = 0; i < numbers.size(); i++) {
				result = result * 10 + numbers.get(i);
				if (isPositive && result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (!isPositive && -result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
			return isPositive ? (int)result : -(int)result;
		}
		return 0;
	}
}
