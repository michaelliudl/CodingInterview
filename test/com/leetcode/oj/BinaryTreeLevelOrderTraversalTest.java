package com.leetcode.oj;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by doliu on 1/3/15.
 */
public class BinaryTreeLevelOrderTraversalTest {
	@Test
	public void testLevelOrderOptimized() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		Assert.assertEquals(Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3)),
				new BinaryTreeLevelOrderTraversal().levelOrderOptimized(root));
	}
}
