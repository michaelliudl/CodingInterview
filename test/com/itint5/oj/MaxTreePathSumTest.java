package com.itint5.oj;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by doliu on 12/14/14.
 */
public class MaxTreePathSumTest {
	@Test
	public void testMaxTreePathSum() {
		TreeNode root = new TreeNode(1);
		root.children = Arrays.asList(new TreeNode(2), new TreeNode(3));
		Assert.assertEquals(6, new MaxTreePathSum().maxTreePathSum(root));
	}

	@Test
	public void testMaxTreePathSum_1() {
		TreeNode minus100 = new TreeNode(-100);
		minus100.children = Arrays.asList(new TreeNode(300), new TreeNode(-200));
		TreeNode three = new TreeNode(3);
		three.children = Arrays.asList(minus100);
		TreeNode root = new TreeNode(1);
		root.children = Arrays.asList(new TreeNode(2), three, new TreeNode(5));
		Assert.assertEquals(300, new MaxTreePathSum().maxTreePathSum(root));
	}
}
