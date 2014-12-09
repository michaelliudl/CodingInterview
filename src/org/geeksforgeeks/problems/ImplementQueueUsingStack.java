package org.geeksforgeeks.problems;

import java.util.Stack;

/**
 * Created by doliu on 11/12/14.
 */
public class ImplementQueueUsingStack {
	class MyQueue<E> {
		private Stack<E> inStack = new Stack<>();
		private Stack<E> outStack = new Stack<>();
		public void enqueue(E e) {
			inStack.push(e);
		}

		public E dequeue() {
			if (!outStack.isEmpty())
				return outStack.pop();
			if (inStack.isEmpty())
				return null;
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
			return outStack.pop();
		}

		// use one explicit stack, recursively pop and push back, return last non-null element
		public E dequeueRecursive() {
			if (inStack.isEmpty()) return null;
			E e = inStack.pop();
			E e1 = dequeueRecursive();
			if (e1 == null) {
				return e;
			} else {
				inStack.push(e);
				return e1;
			}
		}
	}
}
