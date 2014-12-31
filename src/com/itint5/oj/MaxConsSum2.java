package com.itint5.oj;

/**
 * Created by doliu on 12/27/14.
 */
// 环形最大连续子段和
public class MaxConsSum2 {
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
}
