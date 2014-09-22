package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/9/14.
 */
public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		if (start == null || start.length() == 0 || end == null || end.length() == 0 || dict == null || dict.size() == 0)
			return Collections.emptyList();
		Deque<String> current = new ArrayDeque<>(), next = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		current.push(start);
		boolean found = false;
		while (!current.isEmpty()) {
			while (!current.isEmpty()) {
//				String top =
			}
			Deque<String> temp = next;
			next = current;
			current = temp;
		}
		return null;
	}
}
