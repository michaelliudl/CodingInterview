package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 11/10/14.
 */
public class MinStack {

	private Deque<Integer> stack = new ArrayDeque<>();
	private Deque<Integer> stackForMin = new ArrayDeque<>();

	public void push(int x) {
		stack.push(x);
		if (stackForMin.isEmpty() || x <= stackForMin.peek())
			stackForMin.push(x);
	}

	public void pop() {
		if (stack.isEmpty()) return;
		int top = stack.pop();
		if (top == stackForMin.peek())
			stackForMin.pop();
	}

	public int top() {
		return stack.isEmpty() ? 0 : stack.peek();
	}

	public int getMin() {
		return stackForMin.isEmpty() ? 0 : stackForMin.peek();
	}

	class MinStackGeneric<E extends Comparable<E>> {
		public void push(E e) {

		}

		public void pop() {

		}

		public E top() {
			return null;
		}

		public E getMin() {
			return null;
		}
	}
}
