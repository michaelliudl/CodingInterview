package com.leetcode.oj;

/**
 * Created by doliu on 11/3/14.
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) return Integer.MIN_VALUE;
		int n = num.length;
		if (n == 1 || num[0] < num[n - 1]) return num[0];
		if (n == 2) return Math.min(num[0], num[1]);
		int start = 0, end = n - 1, mid = (start + end) / 2;
		while (start <= end) {
			if (start == end) return num[start];
			int before = (mid - 1) >= start ? mid - 1 : start, after = (mid + 1) <= end ? mid + 1 : end;
			if (num[mid] < num[before] && num[mid] < num[after])
				return num[mid];
			if (num[mid] > num[before] && num[mid] > num[after])
				return num[after];
			if (num[mid] > num[start]) start = mid + 1;
			else end = mid - 1;
			mid = (start + end) / 2;
		}
		return Integer.MIN_VALUE;
	}
}
