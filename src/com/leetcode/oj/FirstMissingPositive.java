package com.leetcode.oj;

/**
 * Created by doliu on 9/26/14.
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) return 1;
		int end = segregate(A);
		for (int i = 0; i < end; i++) {
			int value = Math.abs(A[i]) - 1;
			if (value >= 0 && value < end && A[value] > 0) {
				A[value] = -A[value];
			}
		}
		for (int i = 0; i < end; i++) {
			if (A[i] > 0)
				return i + 1;
		}
		return end + 1;
	}

	private int segregate(int[] A) {
		int lastPositive = A.length - 1;
		while (lastPositive >= 0 && A[lastPositive] <= 0)
			lastPositive--;
		for (int j = lastPositive - 1; j >= 0; j--) {
			if (A[j] <= 0) {
				swap(A, lastPositive, j);
				lastPositive--;
			}
		}
		return lastPositive + 1;
	}

	public int firstMissingPositiveBucketSort(int[] A) {
		if (A == null || A.length == 0) return 1;
		bucketSort(A);
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return i + 1;
		}
		return A.length + 1;
	}

	private void bucketSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			while (A[i] != i + 1) {
				if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1])
					break;
				swap(A, i, A[i] - 1);
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
