package com.leetcode.oj;

import java.util.Arrays;

/**
 * Created by doliu on 8/26/14.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) return digits;
		int[] result = new int[digits.length + 1];
		int carry = 1, len = digits.length;
		for (int i = len - 1; i >=0; i--) {
			if (digits[i] + carry >= 10) {
				result[i + 1] = digits[i] + carry - 10;
				carry = 1;
			} else {
				result[i + 1] = digits[i] + carry;
				carry = 0;
			}
		}
		result[0] = carry;
		return result[0] == 1 ? result : Arrays.copyOfRange(result, 1, result.length);
	}
}
