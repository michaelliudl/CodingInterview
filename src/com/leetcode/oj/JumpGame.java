package com.leetcode.oj;

/**
 * Created by doliu on 9/16/14.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) return false;
		int reach = 1;
		for (int i = 0; i < reach; i++) {
			reach = Math.max(reach, i + 1 + A[i]);
			if (reach >= A.length) return true;
		}
		return false;
	}

	// f[i] (i > 0) means the bigger remaining steps from 0 to i
	// f[i] = max(f[i - 1], A[i - 1]) - 1
	public boolean canJumpDP(int[] A) {
		if (A == null || A.length == 0) return false;
		int[] f = new int[A.length];
		f[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			f[i] = Math.max(f[i - 1], A[i - 1]) - 1;
			if (f[i] < 0) return false;
		}
		return f[f.length - 1] >= 0;
	}

	public boolean canJumpDPConstantSpace(int[] A) {
		if (A == null || A.length == 0) return false;
		int last = A[0];
		for (int i = 1; i < A.length; i++) {
			last = Math.max(last, A[i - 1]) - 1;
			if (last < 0) return false;
		}
		return last >= 0;
	}
}
