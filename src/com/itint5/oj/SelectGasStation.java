package com.itint5.oj;

/**
 * Created by doliu on 12/27/14.
 */
// 环形路加油
public class SelectGasStation {

	public int selectGasStation(int[] a, int[] g) {
		if (a == null || g == null || a.length != g.length)
			return -1;
		int diffTotal = 0, diff = 0, start = 0, n = a.length;
		for (int i = 0; i < n; i++) {
			if (diff < 0) {
				start = i;
				diff = 0;
			}
			diffTotal += (a[i] - g[i]);
			diff += (a[i] - g[i]);
		}
		return diffTotal < 0 ? -1 : start;
	}
}
