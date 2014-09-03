package com.leetcode.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 5/7/14.
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length <= 1) {
			return null;
		}
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			numToIndex.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int diff = target - numbers[i];
			if (numToIndex.get(diff) != null && i != numToIndex.get(diff)) {
				return new int[] {i + 1, numToIndex.get(diff) + 1};
			}
		}
		return null;
	}

	public int[] twoSumBrute(int[] numbers, int target) {
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
