package com.leetcode.oj.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 10/1/14.
 */
public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
