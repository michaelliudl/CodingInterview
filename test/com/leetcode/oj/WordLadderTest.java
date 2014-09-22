package com.leetcode.oj;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by doliu on 9/8/14.
 */
public class WordLadderTest {
	@Test
	public void testLadderLength() {
		WordLadder wl = new WordLadder();
		int len = wl.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log")));
		Assert.assertEquals(5, len);
	}
}
