package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 11/8/14.
 */
public class LRUCache {

	private int size = 0;
	private int capacity = 0;
	private Node dummyHead, dummyTail;
	private Map<Integer, Node> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity > 0 ? capacity : 100;
		this.dummyHead = new Node(0, 0, null, null);
		this.dummyTail = new Node(0, 0, null, null);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
	}

	public int get(int key) {
		if (this.map.containsKey(key)) {
			updateRecentAccess(key);
			return this.map.get(key).value;
		}
		return -1;
	}

	private void updateRecentAccess(int key) {
		Node cur = this.map.get(key);
		if (cur != null) {
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
			cur.prev = this.dummyHead;
			cur.next = this.dummyHead.next;
			this.dummyHead.next.prev = cur;
			this.dummyHead.next = cur;
		}
	}

	public void set(int key, int value) {
		if (this.map.containsKey(key)) {
			Node cur = this.map.get(key);
			cur.value = value;
			updateRecentAccess(key);
		} else {
			Node cur = new Node(key, value, this.dummyHead, this.dummyHead.next);
			this.dummyHead.next = cur;
			cur.next.prev = cur;
			this.map.put(key, cur);
			if (size == capacity) {
				Node leastAccessed = this.dummyTail.prev;
				this.map.remove(leastAccessed.key);
				leastAccessed.prev.next = this.dummyTail;
				this.dummyTail.prev = leastAccessed.prev;
			} else
				size++;
		}
	}

	private static class Node {
		private int key, value;
		private Node prev, next;
		private Node(int key, int value, Node prev, Node next) {
			this.key = key;
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
}
