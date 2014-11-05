package com.leetcode.oj;

/**
 * Created by doliu on 11/3/14.
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) return Integer.MIN_VALUE;
		int n = num.length;
		if (n == 1 || num[0] < num[n - 1]) return num[0];
		int start = 0, end = n - 1, mid = (start + end) / 2;
		while (start <= end) {
			if (start == end) return num[start];
			if (num[mid] >= num[start]) {
				if (num[start] > num[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				if (num[mid] < num[end])
					end = mid - 1;
				else
					start = mid + 1;
			}
			mid = (start + end) / 2;
		}
		return Integer.MIN_VALUE;
	}
}
