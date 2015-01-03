package com.lintcode.oj;

/**
 * Created by doliu on 12/12/14.
 */
@Deprecated
// NOT working
public class Backpack {
	/**
	 * @param m: An integer m denotes the size of a backpack
	 * @param A: Given n items with size A[i]
	 * @return: The maximum size
	 */
	public int backPack(int m, int[] A) {
		// write your code here
		if (m <= 0 || A == null || A.length == 0) return 0;
		return backPack(m, A, 0);
	}

	private int backPack(int m, int[] A, int start) {
		if (start == A.length) return 0;
		if (start == A.length - 1) {
			return A[start] <= m ? A[start] : 0;
		}
		int max = 0;
		for (int i = start; i < A.length; i++) {
			if (A[i] == m) return m;
			if (A[i] > m) continue;
			int size = A[i] + backPack(m - A[i], A, i + 1);
			max = Math.max(max, size);
		}
		return max;
	}
}
