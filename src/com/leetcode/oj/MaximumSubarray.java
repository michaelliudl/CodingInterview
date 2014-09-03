package com.leetcode.oj;

/**
 * Created by doliu on 8/31/14.
 */
public class MaximumSubarray {
	// Kadane's algo
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) return 0;
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(sum, max);
		}
		return max;
	}

	public int maxSubArrayPosition(int[] A) {
		if (A == null || A.length == 0) return 0;
		int max = Integer.MIN_VALUE, sum = 0, start = 0, end = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= sum + A[i]) {
				start = i;
				sum = A[i];
			} else {
				sum += A[i];
			}
			if (sum > max) {
				end = i;
				max = sum;
			}
		}
		return max;
	}

	public int maxSubArrayWithExtraSpace(int[] A) {
		if (A == null || A.length == 0) return 0;
		int[] sumOfPrior = new int[A.length + 1];
		sumOfPrior[0] = 0;
		for (int i = 0; i < A.length; i++) {
			sumOfPrior[i + 1] = sumOfPrior[i] + A[i]; // calculate sum of previous i - 1 elements
		}
		int result = Integer.MIN_VALUE;
		int currentMin = 0;
		for (int i = 0; i < A.length; i++) {
			result = Math.max(result, sumOfPrior[i + 1] - currentMin);
			currentMin = Math.min(currentMin, sumOfPrior[i + 1]);
		}
		return result;
	}

	public int maxSubArrayDivideAndConquer(int[] A) {
		if (A == null || A.length == 0) return 0;
		return maxSubArrayDAC(A, 0, A.length - 1);
	}

	private int maxSubArrayDAC(int[] arr, int low, int high) {
		if (low == high) return arr[low];
		int mid = (low + high) / 2;
		return Math.max(Math.max(maxSubArrayDAC(arr, low, mid),
				maxSubArrayDAC(arr, mid + 1, high)),
				maxSubArrayCrossing(arr, low, mid, high)
		);
	}

	private int maxSubArrayCrossing(int[] arr, int low, int mid, int high) {
		int sum = 0, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
		for (int i = mid; i >= low; i--) {
			sum += arr[i];
			if (sum > leftMax) leftMax = sum;
		}
		sum = 0;
		for (int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if (sum > rightMax) rightMax = sum;
		}
		return leftMax + rightMax;
	}

	public int maxSubArrayBrute2Loop(int[] A) {
		if (A == null || A.length == 0) return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if (sum > max) max = sum;
			}
		}
		return max;
	}

	public int maxSubArrayBrute3Loop(int[] A) {
		if (A == null || A.length == 0) return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j <= A.length; j++) {
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += A[k];
				}
				if (sum > max) max = sum;
			}
		}
		return max;
	}
}
