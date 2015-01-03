package com.itint5.oj;

import beans.TreeNode;

/**
 * Created by doliu on 12/9/14.
 * LCA
 */
// 最近公共祖先
public class LowestCommonAncestor {
	public TreeNode getLCA(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) return null;
		int height1 = getHeight(node1), height2 = getHeight(node2);
		TreeNode cur1 = node1, cur2 = node2;
		if (height1 > height2) {
			cur1 = moveUp(node1, Math.abs(height1 - height2));
		} else if (height1 < height2) {
			cur2 = moveUp(node2, Math.abs(height1 - height2));
		}
		while (cur1 != null && cur2 != null) {
			if (cur1 == cur2) return cur1;
			cur1 = cur1.parent;
			cur2 = cur2.parent;
		}
		return null;
	}

	private int getHeight(TreeNode node) {
		int height = 0;
		while (node.parent != null) {
			height++;
			node = node.parent;
		}
		return height;
	}

	private TreeNode moveUp(TreeNode node, int height) {
		TreeNode cur = node;
		while(height > 0) {
			cur = cur.parent;
			height--;
		}
		return cur;
	}
}
