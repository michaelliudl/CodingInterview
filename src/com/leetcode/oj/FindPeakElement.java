package com.leetcode.oj;

/**
 * Created by doliu on 12/9/14.
 */
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0) return -1;
		if (num.length == 1) return 0;
		for (int i = 0; i < num.length; i++) {
			if (i == 0 && num[i] > num[i + 1])
				return i;
			else if (i == num.length - 1 && num[i] > num[i - 1])
				return i;
			else if (i > 0 && i < num.length - 1 && num[i] > num[i - 1] && num[i] > num[i + 1])
				return i;
		}
		return -1;
	}

	public int findPeakElementPadded(int[] num) {
		if (num == null || num.length == 0) return -1;
		int[] numPadded = new int[num.length + 2];
		numPadded[0] = numPadded[numPadded.length - 1] = Integer.MIN_VALUE;
		System.arraycopy(num, 0, numPadded, 1, num.length);
		for (int i = 1; i < numPadded.length - 1; i++) {
			if (numPadded[i] > numPadded[i - 1] && numPadded[i] > numPadded[i + 1])
				return i - 1;
		}
		return -1;
	}
}
