package util;

import beans.TreeNode;

/**
 * Created by doliu on 12/13/14.
 */
public class TreeNodeUtil {
	public static TreeNode getLeftChildNode(TreeNode root) {
		return root == null ? null : root.left;
	}

	public static TreeNode getRightChildNode(TreeNode root) {
		return root == null ? null : root.right;
	}

	public static boolean isNullNode(TreeNode root) {
		return root == null;
	}
}
