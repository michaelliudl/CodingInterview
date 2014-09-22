package com.leetcode.oj;

/**
 * Created by doliu on 8/16/14.
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) return -1;
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[start] == target) return start;
			if (A[end] == target) return end;
			if (A[mid] == target) return mid;
			if (A[mid] > A[start]) {
				if (A[start] > target || A[mid] < target) start = mid + 1;
				else end = mid - 1;
			} else {
				if (A[mid] > target || A[end] < target) end = mid - 1;
				else start = mid + 1;
			}
		}
		return -1;
	}
}
