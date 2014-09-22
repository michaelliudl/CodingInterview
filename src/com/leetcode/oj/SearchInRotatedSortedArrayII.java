package com.leetcode.oj;

/**
 * Created by doliu on 9/11/14.
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) return false;
		int start = 0, end = A.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (A[start] == target || A[end] == target || A[mid] == target) return true;
			if (A[start] < A[mid]) {
				if (target < A[start] || target > A[mid]) start = mid + 1;
				else end = mid - 1;
			} else if (A[start] > A[mid]) {
				if (target < A[mid] || target > A[end]) end = mid - 1;
				else start = mid + 1;
			} else start++;
		}
		return false;
	}
}
