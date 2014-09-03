package com.leetcode.oj;

/**
 * Created by doliu on 8/23/14.
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null || A.length < m + n || B.length < n) return;
		int indexA = m - 1, indexB = n - 1, indexFinal = m + n - 1;
		while (indexA >= 0 && indexB >= 0) {
			A[indexFinal--] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
		}
		while (indexB >= 0) {
			A[indexFinal--] = B[indexB--];
		}
	}
}
