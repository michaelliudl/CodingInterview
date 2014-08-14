package com.leetcode.oj;

/**
 * Created by doliu on 5/13/14.
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) return 0;
		if (A.length == 1) return 1;
		int cur = 0, i = 1;
		while (i < A.length) {
			if (A[i] != A[cur]) {
				if (i - cur > 1) {
					cur++;
					A[cur] = A[i];
					i++;
				} else {
					i++;
					cur++;
				}
			} else {
				i++;
			}
		}
		return cur + 1;
	}
}
