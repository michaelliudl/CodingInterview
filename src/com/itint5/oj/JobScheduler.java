package com.itint5.oj;

import java.util.*;

/**
 * Created by doliu on 12/13/14.
 */
// 任务调度
public class JobScheduler {
	/*
     * deps[id]表示任务id所依赖的任务
     * 如果存在合法的任务完成序列，返回true，否则返回false
     * 合法的任务序列请存放在参数result中（已经分配空间）
     */
	public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
		if (n <= 0 || result == null || result.length != n) return false;
		// calculate in-degree of each node
		int[] inDegree = new int[n + 1]; // task numbered 1 to n
		// convert task dependency to directed graph
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (Map.Entry<Integer, List<Integer>> entry : deps.entrySet()) {
			int key = entry.getKey();
			List<Integer> values = entry.getValue();
			inDegree[key] = values.size();
			for (int value : values) {
				if (!graph.containsKey(value))
					graph.put(value, new ArrayList<Integer>());
				graph.get(value).add(key);
			}
		}
		// calculate topological order
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) // i is task number, tasks without in-degree can be pushed first
			if (inDegree[i] == 0) stack.push(i);
		for (int i = 0; i < n; i++) { // calculate "result" whose index starts from 0
			if (stack.isEmpty()) return false; // no task can result in current task
			int task = stack.pop();
			result[i] = task; // arrange tasks in stack in result
			if (graph.containsKey(task)) {
				// find prerequisite of current task, if in-degree of prerequisite also reaches 0, it can be pushed
				for (int pre : graph.get(task)) {
					inDegree[pre]--;
					if (inDegree[pre] == 0)
						stack.push(pre);
				}
			}
		}
		return true;
	}

	// check DAG and calculate topological order
	@Deprecated
	public boolean jobScheduleTopo(Map<Integer, List<Integer>> deps, int n, int[] result) {
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
			int key = entry.getKey();
			List<Integer> values = entry.getValue();
			for (int v : values) {
				if (!isDag(deps, key, v))
					return false;
			}
		}
		return true;
	}

	private boolean isDag(Map<Integer, List<Integer>> deps, int start, int next) {
		if (!deps.containsKey(next)) return true;
		if (start == next) return false;
		for (int nextDeps : deps.get(next))
			if (!isDag(deps, start, nextDeps))
				return false;
		return true;
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
