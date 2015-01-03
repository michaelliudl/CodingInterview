package org.geeksforgeeks.problems.dp;

/**
 * Created by doliu on 1/1/15.
 */
public class LongestIncreasingSubsequence {
	/**
	 * Find length of longest increasing subsequence
	 *
	 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that arr[i] is part of LIS and arr[i] is the last element in LIS.
	 * Then L(i) can be recursively written as:
	 * L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1.
	 *
	 * To get LIS of a given array, we need to return max(L(i)) where 0 < i < n.
	 */
	public int lengthOfLIS(int[] arr) {
		if (arr == null) return 0;
		if (arr.length <= 1) return arr.length;
		int[] lis = new int[arr.length];
		for (int i = 0; i < arr.length; i++) lis[i] = 1;
		for (int i = 1; i < arr.length; i++) {
			int maxBefore = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] > maxBefore)
					maxBefore = lis[j];
			}
			lis[i] += maxBefore;
		}
		int max = 0;
		for (int i = 0; i < lis.length; i++)
			max = Math.max(max, lis[i]);
		return max;
	}
}
