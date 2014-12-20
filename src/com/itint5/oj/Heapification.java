package com.itint5.oj;

/**
 * Created by doliu on 12/13/14.
 */
public class Heapification {
	/**
	 * @param A: Given an integer array
	 * @return: void
	 */
	public void minHeapify(int[] A) {
		// write your code here
		if (A == null || A.length <= 1) return;
		for (int i = A.length - 1; i >= 0; i--) {
			minHeapify(A, i);
		}
	}

	private void minHeapify(int[] A, int cur) {
		int leftIndex = 2 * cur + 1, rightIndex = 2 * cur + 2;
		int left = leftIndex < A.length ? A[leftIndex] : Integer.MAX_VALUE;
		int right = rightIndex < A.length ? A[rightIndex] : Integer.MAX_VALUE;
		int min = cur;
		if (left < A[min]) min = leftIndex;
		if (right < A[min]) min = rightIndex;
		if (min != cur) {
			swap(A, cur, min);
			minHeapify(A, min);
		}
	}

	private void swap(int[] A, int i, int j) {
		A[i] ^= A[j];
		A[j] ^= A[i];
		A[i] ^= A[j];
	}
}
