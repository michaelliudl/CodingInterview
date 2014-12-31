package com.itint5.oj;

import java.util.*;

/**
 * Created by doliu on 12/27/14.
 */
// 生成匹配的括号序列
public class Generator {
	List<String> generate(int n) {
		if (n <= 0) return Collections.emptyList();
		List<String> result = new ArrayList<>();
		Deque<String> stack = new ArrayDeque<>();
		generate(n, 0, 0, stack, result);
		return result;
	}

	private void generate(int n, int left, int right, Deque<String> stack, List<String> result) {
		if (left == n) {
			int diff = n - right;
			for (int i = diff; i > 0; i--)
				stack.push(")");
			StringBuilder sb = new StringBuilder();
			for (String s : stack)
				sb.insert(0, s);
			result.add(sb.toString());
			for (int i = diff; i > 0; i--)
				stack.pop();
			return;
		}
		stack.push("(");
		generate(n, left + 1, right, stack, result);
		stack.pop();
		// only add right paren when there is less right paren than left paren already added
		if (right < left) {
			stack.push(")");
			generate(n, left, right + 1, stack, result);
			stack.pop();
		}
	}
}
