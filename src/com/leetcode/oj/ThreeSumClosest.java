package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 9/12/14.
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) return 0;
		Arrays.sort(num);
		int maxDiff = Integer.MAX_VALUE, resultSum = 0;
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				int abs = Math.abs(sum - target);
				if (abs == 0) return target;
				if (abs < maxDiff) {
					maxDiff = abs;
					resultSum = sum;
				}
				if (sum > target) k--;
				else j++;
			}
		}
		return resultSum;
	}
}
