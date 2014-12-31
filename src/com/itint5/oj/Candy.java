package com.itint5.oj;

/**
 * Created by doliu on 12/14/14.
 */
// 分配糖果
public class Candy {
	//返回最少需要的糖果数
	// leetcode solution
	public long minimalCandies(int[] ratings) {
		if (ratings == null) return 0;
		if (ratings.length <= 1) return ratings.length;
		int[] count = new int[ratings.length];
		for (int i = 1, inc = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				count[i] = Math.max(inc++, count[i]);
			else inc = 1;
		}
		for (int i = ratings.length - 2, inc = 1; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				count[i] = Math.max(inc++, count[i]);
			else inc = 1;
		}
		long total = ratings.length;
		for (int i = 0; i < ratings.length; i++) {
			total += count[i];
		}
		return total;
	}

	// scan from front and remember count, scan from end to update count
	public long minimalCandies_1(int[] ratings) {
		if (ratings == null) return 0;
		if (ratings.length <= 1) return ratings.length;
		int[] count = new int[ratings.length];
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				count[i] = count[i - 1] + 1;
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1])
				count[i] = count[i + 1] + 1;
		}
		long total = ratings.length;
		for (int i = 0; i < ratings.length; i++) {
			total += count[i];
		}
		return total;
	}
}
