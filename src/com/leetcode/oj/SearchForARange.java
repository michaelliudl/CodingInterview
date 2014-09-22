package com.leetcode.oj;

/**
 * Created by doliu on 9/15/14.
 */
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		if (A == null || A.length == 0) return new int[] {-1, -1};
		int start = 0, end = A.length - 1, pos = -1;
		while (start <= end) {
			if (start == end && target == A[start]) {
				pos = start;
				break;
			}
			int mid = (start + end) / 2;
			if (target == A[mid]) {
				pos = mid;
				break;
			} else if (target < A[mid]) end = mid - 1;
			else start = mid + 1;
		}
		if (pos >= 0) {
			int from = pos, to = pos;
			while (from - 1 >= 0 && target == A[from - 1]) from--;
			while (to + 1 < A.length && target == A[to + 1]) to++;
			return new int[] {from, to};
		}
		return new int[] {-1, -1};
	}
}
