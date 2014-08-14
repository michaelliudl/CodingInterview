package com.leetcode.oj;

import com.leetcode.oj.TwoSum;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwoSumTest {
	private TwoSum solution = new TwoSum();

	@Test
	public void testTwoSum() {
		int[] numbers = {2, 7, 11, 13};
		int target = 9;
		assertThat(solution.twoSum(numbers, target), is(new int[] {1, 2}));
		numbers = new int[] {3, 2, 4};
		target = 6;
		assertThat(solution.twoSum(numbers, target), is(new int[] {2, 3}));
	}


}