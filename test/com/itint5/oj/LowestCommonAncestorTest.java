package com.itint5.oj;

import beans.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by doliu on 12/9/14.
 */
public class LowestCommonAncestorTest {
	@Test
	public void testGetLCA() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node7.parent = node8.parent = node4;
		node5.parent = node6.parent = node2;
		node2.parent = node3.parent = node4.parent = node1;
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Assert.assertEquals(node1, lca.getLCA(node1, node1));
		Assert.assertEquals(node2, lca.getLCA(node2, node2));
		Assert.assertEquals(node3, lca.getLCA(node3, node3));
		Assert.assertEquals(node7, lca.getLCA(node7, node7));
		Assert.assertEquals(node1, lca.getLCA(node1, node5));
		Assert.assertEquals(node1, lca.getLCA(node5, node8));
		Assert.assertEquals(node1, lca.getLCA(node6, node7));
		Assert.assertEquals(node2, lca.getLCA(node5, node6));
		Assert.assertEquals(node4, lca.getLCA(node7, node8));
		Assert.assertEquals(node1, lca.getLCA(node7, node3));
	}

	@Test
	public void testIterator() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Iterator<Integer> iter = list.iterator();
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
//		System.out.println(iter.next());
	}
}
