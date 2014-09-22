package com.leetcode.oj;

/**
 * Created by doliu on 9/17/14.
 */
public class JumpGameII {
	public int jump(int[] A) {
		if (A == null || A.length <= 1) return 0;
		int step = 0, left = 0, right = 0;
		while (left <= right) {
			step++;
			int oldRight = right;
			for (int i = left; i <= oldRight; i++) {
				int newRight = i + A[i];
				if (newRight >= A.length - 1) return step;
				if (newRight > right) right = newRight;
			}
			left = oldRight + 1;
		}
		return 0;
	}

	public int jumpAnother(int[] A) {
		if (A == null || A.length <= 1) return 0;
		// last = max distance reached
		// cur = max distance reached by using "step + 1" steps
		int steps = 0, last = 0, cur = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > last) {
				last = cur;
				steps++;
			}
			cur = Math.max(cur, i + A[i]);
		}
		return steps;
	}
}
