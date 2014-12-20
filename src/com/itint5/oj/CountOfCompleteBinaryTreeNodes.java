package com.itint5.oj;

import beans.TreeNode;
import util.TreeNodeUtil;

/**
 * Created by doliu on 12/13/14.
 */
public class CountOfCompleteBinaryTreeNodes {
	public int countNodes(TreeNode root) {
		if (TreeNodeUtil.isNullNode(root)) return 0;
		int leftHeight = 0;
		TreeNode n = TreeNodeUtil.getLeftChildNode(root);
		while (!TreeNodeUtil.isNullNode(n)) {
			leftHeight++;
			n = TreeNodeUtil.getLeftChildNode(n);
		}
		int rightHeight = 0;
		n = TreeNodeUtil.getRightChildNode(root);
		while (!TreeNodeUtil.isNullNode(n)) {
			rightHeight++;
			n = TreeNodeUtil.getRightChildNode(n);
		}
		if (leftHeight == rightHeight) {
			return (1 << (leftHeight + 1)) - 1;
		} else {
			return countNodes(TreeNodeUtil.getLeftChildNode(root))
					+ countNodes(TreeNodeUtil.getRightChildNode(root))
					+ 1;
		}
	}
}
