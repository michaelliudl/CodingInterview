package com.itint5.oj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by doliu on 12/31/14.
 */
// 表达式求值
public class Evaluation {
	//返回表达式expr的值
	public int evaluate(String expr) {
		if (expr == null) return Integer.MIN_VALUE;
		return evaluate(expr, 0, expr.length() - 1);
	}

	private int evaluate(String expr, int begin, int end) {
		if (begin > end) return 0;
		int plusMinusIndex = -1, multiplyIndex = -1, result = 0, sign = 1;
		for (int i = begin; i <= end; i++) {
			char c = expr.charAt(i);
			if ('+' == c || '-' == c) {
				plusMinusIndex = i;
				sign = '+' == c ? 1 : -1;
			} else if ('*' == c) {
				multiplyIndex = i;
			}
			result = result * 10 + (c - '0');
		}
		if (plusMinusIndex != -1)
			return evaluate(expr, begin, plusMinusIndex - 1) + sign * evaluate(expr, plusMinusIndex + 1, end);
		if (multiplyIndex != -1)
			return evaluate(expr, begin, multiplyIndex - 1) * evaluate(expr, multiplyIndex + 1, end);
		return result;
	}

	// convert to Reverse Polish Notation then evaluate, bugged
	@Deprecated
	public int evaluateWithRPN(String expr) {
		if (expr == null) return Integer.MIN_VALUE;
		List<String> rpn = reversePolishNotation(expr);
		return evaluateRPN(rpn);
	}

	private int evaluateRPN(List<String> rpn) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (String str : rpn) {
			if (isArithmetic(str.charAt(0))) {
				if (stack.size() >= 2) {
					int right = stack.pop();
					int left = stack.pop();
					if ("+".equals(str)) stack.push(left + right);
					else if ("-".equals(str)) stack.push(left - right);
					else if ("*".equals(str)) stack.push(left * right);
					else if ("/".equals(str)) stack.push(left / right);
				}
			} else stack.push(Integer.parseInt(str));
		}
		return stack.isEmpty() ? 0 : stack.pop();
	}

	// 将中缀表达式转换成后缀表达式
	// 要用到栈，从左到右遍历中缀表达式，如果是数字直接输出，
	// 如果是符号：
	// 1、如果是左括号‘（’直接进栈。
	// 2、如果是‘）’右括号，将符号按顺序出栈直到遇到第一个左括号为止。
	// 3、若是+ - * /四个运算符，则与栈顶的运算符相比较，如果优先级高，直接进栈，如果优先级要低于栈顶优先级，那将栈顶元素出栈输出，
	// 然后继续比较，直到该运算符进栈或者栈空为止。
	private List<String> reversePolishNotation(String expr) {
		List<String> result = new ArrayList<>();
		Deque<Character> stack = new ArrayDeque<>();
		int prev = 0;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (isDigit(c)) {
				if (!isDigit(expr.charAt(prev)))
					prev = i;
				if (i == expr.length() - 1)
					result.add(expr.substring(prev));
			} else {
				if (i > prev) {
					Integer operand = null;
					try {
						operand = Integer.parseInt(expr.substring(prev, i));
					} catch (NumberFormatException e) {}
					if (operand != null) result.add(operand.toString());
					prev = i;
				}
				if ('(' == c) stack.push(c);
				else if (')' == c) {
					while (!stack.isEmpty()) {
						if (stack.peek() == '(') {
							stack.pop();
							break;
						}
						result.add(String.valueOf(stack.pop()));
					}
				} else if (isArithmetic(c)) {
					boolean pushed = false;
					while (!stack.isEmpty()) {
						char top = stack.peek();
						if (isArithmetic(top) && higherPriority(top, c)) {
							result.add(String.valueOf(stack.pop()));
						} else {
							stack.push(c);
							pushed = true;
							break;
						}
					}
					if (!pushed) stack.push(c);
				}
			}
		}
		while (!stack.isEmpty()) result.add(String.valueOf(stack.pop()));
		return result;
	}

	private boolean isArithmetic(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private boolean isDigit(char c) {
		return c >= '0' && c<= '9';
	}

	private boolean higherPriority(char cur, char top) {
		return (cur == '*' || cur == '/') && (top == '+' || top == '-');
	}
}
