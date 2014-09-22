package com.leetcode.oj;

/**
 * Created by doliu on 9/13/14.
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length < 1 || cost == null || cost.length < 1 || gas.length != cost.length) return -1;
		int len = gas.length;
		int remaining = 0;
		for (int i = 0; i < len; i++ ) {
			remaining = 0;
			for (int j = i; j < i + len; j++) {
				int k = j % len;
				remaining = remaining + gas[k] - cost[k];
				if (remaining < 0) break;
			}
			if (remaining >= 0) return i;
		}
		return -1;
	}
}
