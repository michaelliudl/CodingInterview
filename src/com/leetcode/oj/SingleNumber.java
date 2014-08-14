package com.leetcode.oj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by doliu on 5/7/14.
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		if (A == null) return Integer.MIN_VALUE;
		Set<Integer> temp = new HashSet<>();
		for (int element : A) {
			if (temp.contains(element)) {
				temp.remove(element);
			} else {
				temp.add(element);
			}
		}
		return temp.iterator().next();
	}

	public int singleNumberNoExtraMemory(int[] A) {
		if (A == null) return Integer.MIN_VALUE;
		Arrays.sort(A);
		for (int i = 0, n = A.length; i < n; i += 2) {
			if (i == n - 1) return A[i];
			if (A[i] != A[i + 1]) {
				return A[i];
			}
		}
		return Integer.MIN_VALUE;
	}
}
