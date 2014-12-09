package com.leetcode.oj;

/**
 * Created by doliu on 8/28/14.
 */
public class TrappingRainWater {
	// find index of max height
	public int trap(int[] A) {
		if (A == null || A.length < 3) return 0;
		int maxIndex = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[maxIndex]) maxIndex = i;
		}
		int area = 0, fromFront = 0, fromEnd = A.length - 1;
		for (int i = 1; i <= maxIndex; i++) {
			if (A[i] < A[fromFront]) area += A[fromFront] - A[i];
			else fromFront = i;
		}
		for (int i = A.length - 2; i >= maxIndex; i--) {
			if (A[i] < A[fromEnd]) area += A[fromEnd] - A[i];
			else fromEnd = i;
		}
		return area;
	}

	// use two arrays to find highest index to left and right of current
	public int trapWithArray(int[] A) {
		if (A == null || A.length < 3) return 0;
		int[] maxToLeft = new int[A.length], maxToRight = new int[A.length];
		for (int i = 1; i < A.length; i++) {
			maxToLeft[i] = Math.max(maxToLeft[i - 1], A[i - 1]);
			maxToRight[A.length - 1 - i] = Math.max(maxToRight[A.length - i], A[A.length - i]);
		}
		int area = 0;
		for (int i = 0; i < A.length; i++) {
			int height = Math.min(maxToLeft[i], maxToRight[i]);
			area += height > A[i] ? (height - A[i]) : 0;
		}
		return area;
	}
}
