package com.leetcode.oj;

/**
 * Created by doliu on 9/13/14.
 */
public class Candy {
	public int candy(int[] ratings) {
		if (ratings == null) return 0;
		if (ratings.length <= 1) return ratings.length;
		int n = ratings.length;
		int[] candy = new int[n];
		for (int i = 0; i < n; i++) {
			candy(ratings, candy, i, n);
		}
		int sum = 0;
		for (int c : candy) sum += c;
		return sum;
	}

	private void candy(int[] ratings, int[] candy, int i, int n) {
		if (candy[i] == 0) {
			candy[i] = 1;
			if (i > 0 && ratings[i] > ratings[i - 1]) {
				candy(ratings, candy, i - 1, n);
				candy[i] = Math.max(candy[i], candy[i - 1] + 1);
			}
			if (i < n - 1 && ratings[i] > ratings[i + 1]) {
				candy(ratings, candy, i + 1, n);
				candy[i] = Math.max(candy[i], candy[i + 1] + 1);
			}
		}
	}

	public int candyIterative(int[] ratings) {
		if (ratings == null) return 0;
		if (ratings.length <= 1) return ratings.length;
		int n = ratings.length;
		int[] candy = new int[n];
		for (int i = 1, inc = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1])
				candy[i] = Math.max(inc++, candy[i]);
			else inc = 1;
		}
		for (int i = n - 2, inc = 1; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candy[i] = Math.max(inc++, candy[i]);
			else inc = 1;
		}
		int sum = n;
		for (int c : candy) sum += c;
		return sum;
	}

	public int candyBrute(int[] ratings) {
		if (ratings == null) return 0;
		if (ratings.length <= 1) return ratings.length;
		int n = ratings.length;
		int[] candy = new int[n];
		for (int i = 0; i < n; i++) candy[i] = 1;
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 1; i < n - 1; i++) {
				if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) {
					int max = Math.max(candy[i - 1], candy[i + 1]);
					if (candy[i] <= max) {
						candy[i] = max + 1;
						changed = true;
					}
				} else if (ratings[i - 1] < ratings[i]) {
					if (candy[i] <= candy[i - 1]) {
						candy[i] = candy[i - 1] + 1;
						changed = true;
					}
				} else if (ratings[i + 1] < ratings[i]) {
					if (candy[i] <= candy[i + 1]) {
						candy[i] = candy[i + 1] + 1;
						changed = true;
					}
				}
			}
			if (ratings[0] > ratings[1] && candy[0] <= candy[1]) {
				candy[0] = candy[1] + 1;
				changed = true;
			}
			if (ratings[n - 1] > ratings[n - 2] && candy[n - 1] <= candy[n - 2]) {
				candy[n - 1] = candy[n - 2] + 1;
				changed = true;
			}
		}
		int sum = 0;
		for (int c : candy) sum += c;
		return sum;
	}
}
