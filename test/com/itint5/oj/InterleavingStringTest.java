package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/28/14.
 */
public class InterleavingStringTest {
	@Test
	public void testIsInterleaving() {
		Assert.assertTrue(new InterleavingString().isInterleaving("abc", "def", "adbecf"));
		Assert.assertTrue(new InterleavingString().isInterleaving("abc", "def", "abcdef"));
		Assert.assertTrue(new InterleavingString().isInterleaving("abc", "def", "abdecf"));
		Assert.assertTrue(new InterleavingString().isInterleaving("abc", "def", "adefbc"));
		Assert.assertTrue(new InterleavingString().isInterleaving("a", "aa", "aaa"));
	}
}
