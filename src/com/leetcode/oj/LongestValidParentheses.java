package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 9/29/14.
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) return 0;
		int max = 0, lastRightParen = -1;
		Deque<Integer> leftParens = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				leftParens.push(i);
			else if (s.charAt(i) == ')') {
				if (leftParens.isEmpty())
					lastRightParen = i;
				else {
					leftParens.pop();
					if (leftParens.isEmpty())
						max = Math.max(max, i - lastRightParen);
					else
						max = Math.max(max, i - leftParens.peek());
				}
			}
		}
		return max;
	}

	public int longestValidParenthesesMemo(String s) {
		if (s == null || s.length() < 2) return 0;
		int[] f = new int[s.length()];
		int max = 0;
		for (int i = s.length() - 2; i >= 0; i--) {
			int match = i + 1 + f[i + 1];
			if (s.charAt(i) == '(' && match < s.length() && s.charAt(match) == ')') {
				f[i] = f[i + 1] + 2;
				if (match + 1 < s.length())
					f[i] += f[match + 1];
			}
			max = Math.max(max, f[i]);
		}
		return max;
	}

	public int longestValidParenthesesTwoPath(String s) {
		if (s == null || s.length() < 2) return 0;
		int max = 0, depth = 0, start = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				depth++;
			else if (s.charAt(i) == ')') {
				depth--;
				if (depth == 0)
					max = Math.max(max, i - start);
				else if (depth < 0) {
					start = i;
					depth = 0;
				}
			}
		}
		depth = 0;
		start = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')')
				depth++;
			else if (s.charAt(i) == '(') {
				depth--;
				if (depth == 0)
					max = Math.max(max, start - i);
				else if (depth < 0) {
					start = i;
					depth = 0;
				}
			}
		}
		return max;
	}
}
