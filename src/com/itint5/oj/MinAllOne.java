package com.itint5.oj;

/**
 * Created by doliu on 12/26/14.
 */
// 两数积全为1
public class MinAllOne {
	// 利用%的性质，(num * 10 + 1) % a = 10 * (num % a) + 1 % a。
	// 除了a为1的情况，都是10 * (num % a) + 1。
	// 然后计算的时候，先去掉是2和5的倍数的情况。
	public int findMinAllOne(int a) {
		if (a <= 0 || a % 2 == 0 || a % 5 == 0) return -1;
		if (a == 1) return 1;
		int num = 1, result = 1;
		while (true) {
			if (num % a == 0) return result;
			num %= a;
			num = num * 10 + 1;
			result++;
		}
	}
}
