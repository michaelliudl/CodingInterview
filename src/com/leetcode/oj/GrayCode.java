package com.leetcode.oj;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/3/14.
 */
public class GrayCode {
	// gray code of n by converting 0 to n - 1
	// GrayCode(n) = n XOR (n / 2)
	// this formula will not generate in the same sequence as OJ expected
	public List<Integer> grayCode(int n) {
		if (n <= 0) return Arrays.asList(0);
		if (n == 1) return Arrays.asList(0, 1);
		List<Integer> prev = grayCode(n - 1);
		Integer[] bin = new Integer[prev.size() * 2];
		for (int i = 0; i < prev.size(); i++) {
			String str = convertToBinString(prev.get(i), n - 1);
			bin[i] = Integer.valueOf("0" + str, 2);
			bin[bin.length - 1 - i] = Integer.valueOf("1" + str, 2);
		}
		return Arrays.asList(bin);
	}

	private String convertToBinString(Integer m, int n) {
		String result = "";
		while (m > 0) {
			result = (m % 2) + result;
			m /= 2;
		}
		while (n - result.length() > 0) {
			result = "0" + result;
		}
		return result;
	}
}
