package com.leetcode.oj;

/**
 * Created by doliu on 9/16/14.
 */
public class SqrtX {
	public int sqrt(int x) {
		if (x == 0 || x == 1) return x;
		int s = x < 0 ? -x : x;
		int i = 1, j = s / 2, lastMid = 0;
		while (i <= j) {
			int mid = (i + j) / 2;
			int other = s / mid;
			if (other == mid) return x < 0 ? -mid : mid;
			else if (other < mid) j = mid - 1;
			else {
				i = mid + 1;
				lastMid = mid;
			}
		}
		return x < 0 ? -lastMid : lastMid;
	}
}
