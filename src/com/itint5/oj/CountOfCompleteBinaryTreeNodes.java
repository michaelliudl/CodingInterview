package com.itint5.oj;

import beans.TreeNode;
import util.TreeNodeUtil;

/**
 * Created by doliu on 12/13/14.
 */
// 统计完全二叉树结点数
public class CountOfCompleteBinaryTreeNodes {
	//使用TreeNodeUtil.getLeftChildNode(TreeNode)获得左儿子结点
	//使用TreeNodeUtil.getRightChildNode(TreeNode)获得右儿子结点
	//使用TreeNodeUtil.isNullNode(TreeNode)判断结点是否为空
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
