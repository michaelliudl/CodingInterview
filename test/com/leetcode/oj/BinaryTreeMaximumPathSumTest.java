package com.leetcode.oj;

import com.leetcode.oj.beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 9/11/14.
 */
public class BinaryTreeMaximumPathSumTest {
	@Test
	public void testMaxPathSum() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		BinaryTreeMaximumPathSum problem = new BinaryTreeMaximumPathSum();
		Assert.assertEquals(3, problem.maxPathSum(root));
	}
}
