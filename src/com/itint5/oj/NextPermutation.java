package com.itint5.oj;

/**
 * Created by doliu on 12/14/14.
 */
public class NextPermutation {
	public boolean nextPermutation(int[] arr) {
		if (arr == null || arr.length == 1) return false;
		int small = arr.length - 2;
		while (small >= 0 && arr[small] >= arr[small + 1]) {
			small--;
		}
		if (small < 0) return false;
		int bigger = arr.length - 1;
		while (arr[bigger] <= arr[small]) {
			bigger--;
		}
		swap(arr, small, bigger);
		reverse(arr, small + 1);
		return true;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void reverse(int[] arr, int start) {
		int s = start, e = arr.length - 1;
		while (s < e) {
			swap(arr, s, e);
			s++;
			e--;
		}
	}
}
