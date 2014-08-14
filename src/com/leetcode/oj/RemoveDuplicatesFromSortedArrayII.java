package com.leetcode.oj;

/**
 * Created by doliu on 8/13/14.
 */
public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null) return 0;
		int MAX_EQUAL = 2;
		if (A.length <= MAX_EQUAL) return A.length;
		int cur = MAX_EQUAL;
		for (int i = MAX_EQUAL; i < A.length; i++) {
			if (A[i] != A[cur - MAX_EQUAL]) {
				A[cur] = A[i];
				cur++;
			}
		}
		return cur;
	}
}
