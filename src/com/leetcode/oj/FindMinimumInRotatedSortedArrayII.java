package com.leetcode.oj;

/**
 * Created by doliu on 11/6/14.
 */
public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) return Integer.MIN_VALUE;
		int start = 0, end = num.length - 1;
		return findMin(num, start, end);
	}

	private int findMin(int[] num, int start, int end) {
		if (start == end) return num[start];
		int mid = (start + end) / 2;
		if (mid < end && num[mid] > num[mid + 1])
			return num[mid + 1];
		if (mid > start && num[mid - 1] > num[mid])
			return num[mid];
		int newEnd = mid - 1 >= start ? mid - 1 : start,
				newStart = mid + 1 <= end ? mid + 1 : end;
		if (num[mid] == num[start] && num[mid] == num[end])
			return Math.min(findMin(num, start, newEnd), findMin(num, newStart, end));
		if (num[end] >= num[mid])
			return findMin(num, start, newEnd);
		else
			return findMin(num, newStart, end);
	}
}
