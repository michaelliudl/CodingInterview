package com.leetcode.oj;

/**
 * Created by doliu on 8/28/14.
 */
public class TrappingRainWater {
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
}
