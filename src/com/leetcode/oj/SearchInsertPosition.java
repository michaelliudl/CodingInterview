package com.leetcode.oj;

/**
 * Created by doliu on 5/7/14.
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null) return -1;
		if (A.length == 0 || target <= A[0]) return 0;
		for (int i = 0, n = A.length; i < n; i++) {
			if (i == n - 1) {
				if (A[i] >= target) {
					return i;
				} else {
					return n;
				}
			}
			if (A[i] < target && A[i + 1] >= target) {
				return i + 1;
			}
		}
		return -1;
	}
}
