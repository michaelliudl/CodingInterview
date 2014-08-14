package com.leetcode.oj;

import com.leetcode.oj.ReverseWordsInString;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReverseWordsInStringTest {
	private ReverseWordsInString solution = new ReverseWordsInString();

	@Test
	public void testReverse() {
		solution.reverseWords("   a   b ");
	}


}