package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/8/14.
 */
public class WordLadder {
	// BFS
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || start.length() == 0 || end == null || end.length() == 0 || dict == null || dict.size() == 0)
			return 0;
		Deque<String> current = new ArrayDeque<>(), next = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		int level = 0;
		current.push(start);
		while (!current.isEmpty()) { // have more levels
			level++;
			while (!current.isEmpty()) { // have more to expand in current level
				String top = current.pop();
				List<String> newStates = extendState(top, end, dict, visited);
				for (String newState : newStates) {
					next.add(newState);
					if (end.equalsIgnoreCase(newState)) {
						return ++level;
					}
				}
			}
			Deque<String> temp = next;
			next = current;
			current = temp;
		}
		return 0;
	}

	private List<String> extendState(String str, String end, Set<String> dict, Set<String> visited) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				String expansion = str.substring(0, i) + c + str.substring(i + 1, str.length());
				if (end.equalsIgnoreCase(expansion)) {
					result.add(expansion);
					return result;
				}
				if (dict.contains(expansion) && !visited.contains(expansion)) {
					result.add(expansion);
					visited.add(expansion);
				}
			}
		}
		return result;
	}

	// try to find all possibilities, time out
	public int ladderLengthTimeOut(String start, String end, Set<String> dict) {
		if (start == null || start.length() == 0 || end == null || end.length() == 0 || dict == null || dict.size() == 0) return 0;
		Deque<String> path = new ArrayDeque<>();
		path.push(start);
		List<List<String>> all = new ArrayList<>();
		ladderLength(start, end, dict, path, all);
		int min = Integer.MAX_VALUE;
		for (List<String> p : all) {
			if (p.size() < min) min = p.size();
		}
		return min;
	}

	private void ladderLength(String cur, String end, Set<String> dict, Deque<String> path, List<List<String>> all) {
		if (end.equalsIgnoreCase(cur)) {
			List<String> p = new ArrayList<>();
			for (String w : path) {
				p.add(0, w);
			}
			all.add(p);
			return;
		}
		if (editDistance(cur, end) == 1) {
			path.push(end);
			ladderLength(end, end, dict, path, all);
			path.pop();
		} else {
			for (String d : dict) {
				if (!path.contains(d) && editDistance(cur, d) == 1) {
					path.push(d);
					ladderLength(d, end, dict, path, all);
					path.pop();
				}
			}
		}
	}

	private int editDistance(String cur, String target) {
		int distance = 0;
		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != target.charAt(i)) distance++;
		}
		return distance;
	}
}
