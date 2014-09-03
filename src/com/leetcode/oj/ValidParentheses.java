package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 9/2/14.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || (s.length() & 0x1) == 1) return false;
		Deque<String> left = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{') {
				left.push(String.valueOf(s.charAt(i)));
			} else if (cur == ')' || cur == ']' || cur == '}') {
				if (left.isEmpty()) return false;
				String top = left.peek();
				if ((cur == ')' && "(".equals(top))
						|| (cur == ']' && "[".equals(top))
						|| (cur == '}' && "{".equals(top))) {
					left.pop();
				}
			} else {
				return false;
			}
		}
		return left.isEmpty();
	}

	public boolean isValidTwoStacks(String s) {
		if (s == null || (s.length() & 0x1) == 1) return false;
		Deque<String> full = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			full.push(String.valueOf(s.charAt(i)));
		}
		Deque<String> right = new ArrayDeque<>();
		while (!full.isEmpty()) {
			String top = full.pop();
			if (")".equals(top) || "]".equals(top) || "}".equals(top)) {
				right.push(top);
			} else if ("(".equals(top) || "[".equals(top) || "{".equals(top)) {
				if (right.isEmpty()) return false;
				String rightTop = right.pop();
				if (("(".equals(top) && !")".equals(rightTop))
						|| ("[".equals(top) && !"]".equals(rightTop))
						|| ("{".equals(top) && !"}".equals(rightTop))) {
					return false;
				}
			}
		}
		return true;
	}
}
