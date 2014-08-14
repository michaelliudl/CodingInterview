package com.leetcode.oj;

import java.util.Stack;

/**
 * Created by doliu on 5/7/14.
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		try {
			for (String t : tokens) {
				if ("+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t)) {
					int rightOperand = stack.pop();
					int leftOperand = stack.pop();
					if ("+".equals(t)) {
						stack.push(leftOperand + rightOperand);
					} else if ("-".equals(t)) {
						stack.push(leftOperand - rightOperand);
					} else if ("*".equals(t)) {
						stack.push(leftOperand * rightOperand);
					} else if ("/".equals(t)) {
						stack.push(leftOperand / rightOperand);
					}
				} else {
					stack.push(Integer.parseInt(t));
				}
			}
			if (stack.isEmpty()) {
				return 0;
			}
			return stack.pop();
		} catch (Exception e) {
			return 0;
		}
	}
}
