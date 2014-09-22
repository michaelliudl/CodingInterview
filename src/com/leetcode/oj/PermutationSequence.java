package com.leetcode.oj;

/**
 * Created by doliu on 9/12/14.
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (n <= 1) return String.valueOf(n);
		int[] array = new int[n];
		int factorial = 1;
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
			factorial *= i + 1;
		}
		int loop = k > factorial ? k % factorial : k;
		for (int i = 1; i < loop; i++) {
			nextPermutation(array);
		}
		StringBuilder sb = new StringBuilder();
		for (int e : array) sb.append(e);
		return sb.toString();
	}

	private void nextPermutation(int[] cur) {
		int firstNonAscFromBack = cur.length - 1;
		while (firstNonAscFromBack > 0) {
			if (cur[firstNonAscFromBack - 1] < cur[firstNonAscFromBack]) {
				firstNonAscFromBack--;
				break;
			} else firstNonAscFromBack--;
		}
		int firstLargerFromBack = cur.length - 1;
		while (firstLargerFromBack > firstNonAscFromBack) {
			if (cur[firstLargerFromBack] < cur[firstNonAscFromBack]) firstLargerFromBack--;
			else break;
		}
		swap(cur, firstNonAscFromBack, firstLargerFromBack);
		reverse(cur, firstNonAscFromBack + 1, cur.length - 1);
	}

	private void reverse(int[] arr, int start, int end) {
		while (start < end) {
			swap(arr, start++, end--);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
