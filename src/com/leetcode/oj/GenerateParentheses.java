package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/5/14.
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		if (n < 1) return Collections.emptyList();
		List<String> agg = new ArrayList<>();
		generate(n, 0, 0, "", agg);
		return agg;
	}

	private void generate(int n, int left, int right, String result, List<String> agg) {
		if (left == n) {
			for (int i = 0; i < n - right; i++) result += ")";
			agg.add(result);
			return;
		}
		generate(n, left + 1, right, result + "(", agg);
		if (right < left)
			generate(n, left, right + 1, result + ")", agg);
	}

	public List<String> generateParenthesisInnerOuter(int n) {
		if (n <= 0) return Arrays.asList("");
		if (n == 1) return Arrays.asList("()");
		List<String> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (String outer : generateParenthesisInnerOuter(i)) {
				for (String inner : generateParenthesisInnerOuter(n - 1 - i)) {
					result.add("(" + inner + ")" + outer);
				}
			}
		}
		return result;
	}
}
