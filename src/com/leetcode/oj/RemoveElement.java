package com.leetcode.oj;

/**
 * Created by doliu on 8/25/14.
 */
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) return 0;
		int pos = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) A[pos++] = A[i];
		}
		return pos;
	}
}
