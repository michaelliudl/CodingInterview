package com.leetcode.oj;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by doliu on 5/9/14.
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) return path;
		String[] dirs = path.split("/");
		Deque<String> deque = new ArrayDeque<>();
		for (String dir : dirs) {
			if (dir == null || dir.length() == 0 || ".".equals(dir)) continue;
			if ("..".equals(dir)) {
				if (!deque.isEmpty()) {
					deque.pop();
				}
			} else {
				deque.push(dir);
			}
		}
		if (deque.isEmpty()) return "/";
		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append("/");
			sb.append(deque.pollLast());
		}
		return sb.toString();
	}
}
