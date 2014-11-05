package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 10/3/14.
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) return 0;
		if (A.length == 1) return A[0];
		int max = Integer.MIN_VALUE, curMax = 1, curMin = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				curMax *= A[i];
				curMin = Math.min(curMin * A[i], 1);
				max = Math.max(max, curMax);
			} else if (A[i] == 0) {
				max = Math.max(max, 0);
				curMax = curMin = 1;
			} else {
				max = Math.max(max, curMin * A[i]);
				int prevMax = curMax;
				curMax = Math.max(curMin * A[i], 1);
				curMin = prevMax * A[i];
			}
		}
		return max;
	}

	public int maxProductDivideAndConquer(int[] A) {
		if (A == null || A.length == 0) return 0;
		if (A.length == 1) return A[0];
		List<Integer> zeroPos = new ArrayList<>();
		for (int i = 0; i < A.length; i++)
			if (A[i] == 0) zeroPos.add(i);
		if (zeroPos.isEmpty())
			return maxProductWithoutZero(A, 0, A.length - 1);
		List<Integer> maxBySegment = new ArrayList<>();
		for (int i = 0; i < zeroPos.size(); i++) {
			int start = i == 0 ? 0 : zeroPos.get(i - 1) + 1;
			int end = zeroPos.get(i) - 1;
			maxBySegment.add(maxProductWithoutZero(A, start, end));
		}
		maxBySegment.add(maxProductWithoutZero(A, zeroPos.get(zeroPos.size() - 1) + 1, A.length - 1));
		int max = 0;
		for (int segMax : maxBySegment)
			max = Math.max(max, segMax);
		return max;
	}

	private int maxProductWithoutZero(int[] array, int start, int end) {
		if (start > end) return 0;
		if (start == end) return array[start];
		List<Integer> negativePos = new ArrayList<>();
		for (int i = start; i <= end; i++)
			if (array[i] < 0) negativePos.add(i);
		int product = 1;
		if ((negativePos.size() & 0x1) == 0) {
			for (int i = start; i <= end; i++) product *= array[i];
		} else {
			int firstNegative = negativePos.get(0), lastNegative = negativePos.get(negativePos.size() - 1);
			int prod1 = 1, prod2 = 1;
			for (int i = start; i < lastNegative; i++)
				prod1 *= array[i];
			for (int i = firstNegative + 1; i <= end; i++)
			    prod2 *= array[i];
			product = Math.max(prod1, prod2);
		}
		return product;
	}
}
