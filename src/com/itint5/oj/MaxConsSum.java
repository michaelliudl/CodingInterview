package com.itint5.oj;

/**
 * Created by doliu on 12/27/14.
 */
// 最大连续子段和
public class MaxConsSum {
	public int maxConsSum(int[] arr) {
		if (arr == null) return 0;
		int max = 0, cur = 0;
		for (int i = 0; i < arr.length; i++) {
			cur = Math.max(cur + arr[i], arr[i]);
			max = Math.max(max, cur);
		}
		return max;
	}
}
