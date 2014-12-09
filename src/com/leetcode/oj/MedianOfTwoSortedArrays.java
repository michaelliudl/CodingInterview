package com.leetcode.oj;

/**
 * Created by doliu on 8/28/14.
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if ((A == null || A.length == 0) && (B == null || B.length == 0)) return 0.0;
		if (A == null || A.length == 0) return ((B.length & 0x1) == 1) ? B[B.length / 2] : (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
		if (B == null || B.length == 0) return ((A.length & 0x1) == 1) ? A[A.length / 2] : (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0;
		int total = A.length + B.length;
		int k = total / 2;
		if ((total & 0x1) == 1) {
			return findKthInTwoSortedArrays(A, 0, B, 0, k + 1); // k is length instead of index
		} else {
			return (findKthInTwoSortedArrays(A, 0 , B, 0, k) + findKthInTwoSortedArrays(A, 0, B, 0, k + 1)) / 2.0;
		}
	}

	private int findKthInTwoSortedArrays(int[] A, int startA, int[] B, int startB, int k) {
		int remainingA = A.length - startA;
		int remainingB = B.length - startB;
		if (remainingA > remainingB) return findKthInTwoSortedArrays(B, startB, A, startA, k);
		if (remainingA == 0) return B[startB + k - 1];
		if (k == 1) return Math.min(A[startA], B[startB]);
		// divide k into 2 parts
		int half = k / 2;
		int lenHalfKthA = remainingA > half ? half : remainingA;
		int lenHalfKthB = k - lenHalfKthA;
		int halfKthA = A[startA + lenHalfKthA - 1];
		int halfKthB = B[startB + lenHalfKthB - 1];
		if (halfKthA < halfKthB) return findKthInTwoSortedArrays(A, startA + lenHalfKthA, B, startB, k - lenHalfKthA);
		else if (halfKthA > halfKthB) return findKthInTwoSortedArrays(A, startA, B, startB + lenHalfKthB, k - lenHalfKthB);
		else return halfKthA;
	}

	public double findMedianSortedArraysAnother(int A[], int B[]) {
		if ((A == null || A.length == 0) && (B == null || B.length == 0)) return 0.0;
		if (A == null || A.length == 0) return ((B.length & 0x1) == 1) ? B[B.length / 2] : (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
		if (B == null || B.length == 0) return ((A.length & 0x1) == 1) ? A[A.length / 2] : (A[A.length / 2] + A[A.length / 2 - 1]) / 2.0;
		int total = A.length + B.length;
		int k = total / 2;
		if ((total & 0x1) == 1) {
			return findKthInTwoSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, k + 1); // k is length instead of index
		} else {
			return (findKthInTwoSortedArrays(A, 0 , A.length - 1, B, 0, B.length - 1, k) + findKthInTwoSortedArrays(A, 0, A.length - 1, B, 0, B.length - 1, k + 1)) / 2.0;
		}
	}

	private int findKthInTwoSortedArrays(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
		int remainingA = endA - startA + 1, remainingB = endB - startB + 1;
		if (remainingA == 0) return B[startB + k - 1];
		if (remainingB == 0) return A[startA + k - 1];
		if (k == 1) return Math.min(A[startA], B[startB]);
		int midA = (startA + endA) / 2, midB = (startB + endB) / 2, half = (remainingA + remainingB) / 2 + 1;
		if (half >= k)
			if (A[midA] >= B[midB])
				return findKthInTwoSortedArrays(A, startA, midA - 1, B, startB, endB, k);
			else
				return findKthInTwoSortedArrays(A, startA, endA, B, startB, midB - 1, k);
		else
			if (A[midA] >= B[midB])
				return findKthInTwoSortedArrays(A, startA, endA, B, midB + 1, endB, k - (remainingB / 2 + 1));
			else
				return findKthInTwoSortedArrays(A, midA + 1, endA, B, startB, endB, k - (remainingA / 2 + 1));
	}
}
