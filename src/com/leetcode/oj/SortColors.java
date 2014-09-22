package com.leetcode.oj;

/**
 * Created by doliu on 9/3/14.
 */
public class SortColors {
	public void sortColors(int[] A) {
		if (A == null) return;
		int red = 0, white = 0, blue = 0;
		for (int i : A) {
			if (i == 0) red++;
			else if (i == 1) white++;
			else if (i == 2) blue++;
		}
		for (int i = 0; i < red; i++) A[i] = 0;
		for (int i = red; i < (red + white); i++) A[i] = 1;
		for (int i = (red + white); i < (red + white + blue); i++) A[i] = 2;
	}

	public void sortColorsOnePass(int[] A) {
		if (A == null) return;
		int redEnd = 0, blueStart = A.length - 1;
		for (int i = 0; i <= blueStart;) {
			if (A[i] == 0) {
				swap(A, i, redEnd);
				i++;
				redEnd++;
			} else if (A[i] == 2) {
				swap(A, i, blueStart);
				blueStart--;
			} else {
				i++;
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
