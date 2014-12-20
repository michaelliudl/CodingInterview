package beans;

import java.util.List;

/**
 * Created by doliu on 6/12/14.
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	// for LCA problem, we have only parent pointer
	public TreeNode parent;
	// for tree max path sum problem, could have more than binary branches
	public List<TreeNode> children;

	public TreeNode(int x) { val = x; }

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
