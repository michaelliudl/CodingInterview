package com.itint5.oj;

/**
 * Created by doliu on 12/27/14.
 */
// 环形最大连续子段和
public class MaxConsSum2Circle {

	/**
	 1 = max sum not crossing arr[n-1] and arr[0], Kadane
	 2 = calculate min sum between arr[0] and arr[n - 1], max sum crossing = total - min sum
	 result = max(#1, #2)
	 */
	// remember consecutive min sum and consecutive max sum
	// compare consecutive max sum and (total - consecutive min sum)
	public int maxConsSum2(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		if (arr.length == 1) return arr[0];
		int n = arr.length, max = 0, maxSum = 0, min = 0, minSum = 0, total = 0;
		for (int i = 0; i < n; i++) {
			total += arr[i];
			maxSum = Math.max(maxSum + arr[i], arr[i]);
			max = Math.max(max, maxSum);
			minSum = Math.min(minSum + arr[i], arr[i]);
			min = Math.min(min, minSum);
		}
		return Math.max(max, total - min);
	}

	/**
	 * duplicate array and find max sum subarray shorter than n + 1
	 * @param arr
	 * @return
	 */
	public int maxConsSum2DuplicateArray(int[] arr) {
		if (arr == null || arr.length == 0) return 0;
		if (arr.length == 1) return arr[0];
		int n = arr.length, max = 0, sum = 0, cur = 0, start = 0;
		int[] dup = new int[n << 1];
		System.arraycopy(arr, 0, dup, 0, n);
		System.arraycopy(arr, 0, dup, n, n);
		for (int i = 0; i < dup.length; i++) {
			if (sum + dup[i] < dup[i]) {
				sum = dup[i];
				start = cur = i;
			} else {
				if (cur - start >= n) return max;
				sum += dup[i];
				cur++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
