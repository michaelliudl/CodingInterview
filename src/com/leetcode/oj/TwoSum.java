package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 5/7/14.
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length <= 1) {
			return null;
		}
		int[] numbersDup = new int[numbers.length];
		System.arraycopy(numbers, 0, numbersDup, 0, numbersDup.length);
		Arrays.sort(numbers);
		int start = 0, end = numbers.length - 1;
		while(start < end) {
			int first = numbers[start], second = numbers[end];
			if (first + second == target) {
				int originalStart = 0, originalEnd = 0;
				for (int i = 0; i < numbersDup.length; i++) {
					if (numbersDup[i] == first) {
						originalStart = i;
					}
					if (numbersDup[i] == second) {
						originalEnd = i;
					}
				}
				return new int[] {originalStart + 1, originalEnd + 1};
			}
			int diff = target - first;
			if (second > diff) {
				end--;
			} else {
				start++;
			}
		}
		return null;
	}

	public int[] twoSum_1(int[] numbers, int target) {
		if (numbers == null || numbers.length <= 1) {
			return null;
		}
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] {i + 1, j + 1};
				}
			}
		}
		return null;
	}
}
