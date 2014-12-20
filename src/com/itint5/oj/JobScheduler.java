package com.itint5.oj;

import java.util.*;

/**
 * Created by doliu on 12/13/14.
 */
@Deprecated
// not checking non-DAG
public class JobScheduler {
	/*
     * deps[id]表示任务id所依赖的任务
     * 如果存在合法的任务完成序列，返回true，否则返回false
     * 合法的任务序列请存放在参数result中（已经分配空间）
     */
	public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
	                           int[] result) {
		if (n <= 0 || result == null || result.length != n) return false;
		boolean isDag = isDag(deps);
		if (isDag) {
			Set<Integer> visited = new HashSet<>();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				if (!visited.contains(i)) {
					jobSchedule(i, deps, visited, queue);
				}
			}
			int i = 0;
			while (!queue.isEmpty()) {
				result[i++] = queue.poll();
			}
			return true;
		}
		return false;
	}

	private boolean isDag(Map<Integer, List<Integer>> deps) {
		for (Map.Entry<Integer, List<Integer>> entry : deps.entrySet()) {
			if (!isDag(deps, entry.getKey()))
				return false;
		}
		return false;
	}

	private boolean isDag(Map<Integer, List<Integer>> deps, Integer start) {

		return false;
	}

	private void jobSchedule(int cur, Map<Integer, List<Integer>> deps, Set<Integer> visited, Queue<Integer> queue) {
		visited.add(cur);
		if (deps.containsKey(cur)) {
			for (Integer dep : deps.get(cur)) {
				if (!visited.contains(dep)) {
					jobSchedule(dep, deps, visited, queue);
				}
			}
		}
		queue.offer(cur);
	}
}
