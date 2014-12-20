package com.leetcode.oj;

import beans.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 10/1/14.
 */
public class CloneGraph {
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<Integer, UndirectedGraphNode> cache = new HashMap<>();
		return dfs(node, cache);
	}

	private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> cache) {
		if (cache.containsKey(node.label)) return cache.get(node.label);
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		cache.put(node.label, copy);
		for (UndirectedGraphNode n : node.neighbors)
			copy.neighbors.add(dfs(n, cache));
		return copy;
	}

	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) return null;
		Map<Integer, UndirectedGraphNode> cache = new HashMap<>();
		Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
		queue.offer(node);
		cache.put(node.label, new UndirectedGraphNode(node.label));
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			if (!cache.containsKey(cur.label))
				cache.put(cur.label, new UndirectedGraphNode(cur.label));
			if (cur.neighbors != null) {
				UndirectedGraphNode copy = cache.get(cur.label);
				for (UndirectedGraphNode n : cur.neighbors) {
					if (!cache.containsKey(n.label)) {
						cache.put(n.label, new UndirectedGraphNode(n.label));
						queue.offer(n);
					}
					copy.neighbors.add(cache.get(n.label));
				}
			}
		}
		return cache.get(node.label);
	}
}
