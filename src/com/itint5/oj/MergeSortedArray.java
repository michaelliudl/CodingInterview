package com.itint5.oj;

/**
 * Created by doliu on 12/27/14.
 */
// 有序数组合并
public class MergeSortedArray {
	public void mergeSortedArray(int[] arr1, int[] arr2, int n, int m) {
		if (arr1 == null || arr2 == null) return;
		int cur = n + m - 1, index1 = n - 1, index2 = m - 1;
		while (index1 >=0 && index2 >= 0) {
			arr1[cur--] = arr1[index1] >= arr2[index2] ? arr1[index1--] : arr2[index2--];
		}
		while (index2 >= 0) {
			arr1[cur--] = arr2[index2--];
		}
	}
}
