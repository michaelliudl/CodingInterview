package com.itint5.oj;

/**
 * Created by doliu on 12/29/14.
 */
// 两有序数组的交和并
public class ArraysUnionAndIntersect {
	public int[] arrayUnion(int[] a, int[] b) {
		if (a == null) a = new int[0];
		if (b == null) b = new int[0];
		int[] c = init(a.length + b.length);
		int index = 0, i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				if (index == 0 || a[i] > c[index - 1])
					c[index++] = a[i];
				i++;
			} else if (a[i] > b[j]) {
				if (index == 0 || b[j] > c[index - 1])
					c[index++] = b[j];
				j++;
			} else {
				if (index == 0 || a[i] > c[index - 1])
					c[index++] = a[i];
				i++;
				j++;
			}
		}
		while (i < a.length)
			if (index == 0 || a[i] > c[index - 1])
				c[index++] = a[i++];
			else i++;
		while (j < b.length)
			if (index == 0 || b[j] > c[index - 1])
				c[index++] = b[j++];
			else j++;
		return getResult(c);
	}

	public int[] arrayIntersect(int[] a, int[] b) {
		if (a == null || a.length == 0 || b == null || b.length == 0) return new int[0];
		int[] c = init(Math.min(a.length, b.length));
		int index = 0, i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				if (index == 0 || a[i] > c[index - 1])
					c[index++] = a[i];
				i++;
				j++;
			}
		}
		return getResult(c);
	}

	private int[] init(int len) {
		int[] c = new int[len];
		for (int i = 0; i < c.length; i++) c[i] = Integer.MIN_VALUE;
		return c;
	}

	private int[] getResult(int[] c) {
		if (c.length == 0) return c;
		int k = 0;
		while (k < c.length && c[k] > Integer.MIN_VALUE) k++;
		int[] result = new int[k];
		System.arraycopy(c, 0, result, 0, k);
		return result;
	}
}
