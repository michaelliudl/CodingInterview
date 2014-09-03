package com.leetcode.oj;

/**
 * Created by doliu on 8/30/14.
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1) return;
		int len = num.length;
		if (num[len - 1] > num[len - 2]) {
			swap(num, len - 1, len - 2);
			return;
		}
		// find first non ascending element from back
		int firstSmall = len - 2;
		while (firstSmall >=0 && num[firstSmall] >= num[firstSmall + 1]) {
			firstSmall--;
		}
		if (firstSmall >= 0) {
			int nextBig = len - 1;
			while (nextBig > firstSmall && num[nextBig] <= num[firstSmall]) nextBig--;
			swap(num, firstSmall, nextBig);
		}
		reverse(num, firstSmall + 1);
	}

	private void reverse(int[] num, int start) {
		for (int i = start, j = num.length - 1; i <= j; i++, j--) {
			swap(num, i, j);
		}
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
