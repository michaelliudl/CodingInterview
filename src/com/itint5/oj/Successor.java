package com.itint5.oj;

import java.util.*;

/**
 * Created by doliu on 12/14/14.
 */
// 支持删除的后继查询
// O(lgN) => BBST, threaded for successor
// O(1) amortised => array to store successor

public class Successor {

	private int[] array;

	public void init(int N) {
		if (N <= 0) array = new int[0];
		else array = new int[N];
		for (int i = 0; i < N; i++) array[i] = i;
	}

	public void removeNum(int x) {
//		if (x >= 0 && x < array.length) {
//			int old = array[x], i = x;
//			while (i >= 0 && array[i] == old)
//				array[i--] = x == array.length - 1 ? -1 : array[x + 1];
//		}
		if (x >= 0 && x < array.length)
			array[x] = query(x + 1);
	}

	public int query(int x) {
//		return x >= 0 && x < array.length ? array[x] : -1;
		if (x >= 0 && x < array.length) {
			if (array[x] == x || array[x] == -1)
				return array[x];
			int next = query(array[x]);
			array[x] = next;
			return next;
		}
		return -1;
	}

	// O(1) amortised => hashmap and double linked list
	// time out for large N
	@Deprecated
	private static class SuccessorHashMapLinkedList {

		private Map<Integer, Node> map = new HashMap<>();
		private Node head = new Node(Integer.MIN_VALUE);
		private Node tail = new Node(Integer.MAX_VALUE);

		public void init(int N) {
			head.next = tail;
			tail.prev = head;
			if (N >= 0) {
				Node prev = head;
				for (int i = 0; i < N; i++) {
					Node cur = new Node(i);
					map.put(i, cur);
					prev.next = tail.prev = cur;
					cur.prev = prev;
					cur.next = tail;
					prev = cur;
				}
			}
		}

		public void removeNum(int x) {
			if (map.containsKey(x)) {
				Node cur = map.remove(x);
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
			}
		}

		public int query(int x) {
			if (map.containsKey(x)) {
				return x;
			} else if (x == 0) {
				return head.next == tail ? -1 : head.next.val;
			} else if (x > 0) {
				int y = x;
				while (!map.containsKey(y) && y <= tail.prev.val)
					y <<= 1;
				if (y > tail.prev.val) y = tail.prev.val;
				if (map.containsKey(y)) {
					Node cur = map.get(y);
					while (cur.val > x) cur = cur.prev;
					return cur.next.val;
				}
			}
			return -1;
		}

		final static class Node {
			int val;
			Node prev, next;

			public Node(int val) {
				this.val = val;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;

				Node node = (Node) o;

				if (val != node.val) return false;

				return true;
			}

			@Override
			public int hashCode() {
				return val;
			}
		}
	}
}
