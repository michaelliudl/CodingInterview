package com.itint5.oj;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 1/2/15.
 */
public class ThreadedBinaryTreeTest {
	@Test
	public void testConvertToThreadedTree() {
		TreeNode root1 = createNonThreadedTree();
		new ThreadedBinaryTree().convertToThreadedTreeRecursive(root1);
		TreeNode root2 = createNonThreadedTree();
		new ThreadedBinaryTree().convertToThreadedTreeIterative(root2);
		boolean isSame = isSameThreadedTree(root1, root2);
		Assert.assertTrue(isSame);
	}

	private boolean isSameThreadedTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null || root2 == null) return false;
		boolean isSame = root1.val == root2.val;
		isSame &= root1.isLeftThread ? root2.isLeftThread && root1.left.val == root2.left.val : !root2.isLeftThread;
		isSame &= root1.isRightThread ? root2.isRightThread && root1.right.val == root2.right.val : !root2.isRightThread;
		return isSame;
	}

	private TreeNode createNonThreadedTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		root.left = node2;
		root.right = node5;
		node2.left = node3;
		node2.right = node4;
		return root;
	}
}
