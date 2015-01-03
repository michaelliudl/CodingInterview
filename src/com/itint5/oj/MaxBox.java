package com.itint5.oj;

import beans.Box;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by doliu on 12/14/14.
 */
// 堆放积木
public class MaxBox {
	// Sort by one dimension then find Longest Increasing Subsequence for the other dimension
	public int maxBoxes(Box[] boxes) {
		if (boxes == null) return 0;
		if (boxes.length <= 1) return boxes.length;
		// sort by volume
		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return o1.vol - o2.vol;
			}
		});
		// find LIS of weight
		return findLIS(boxes);
	}

	private int findLIS(Box[] boxes) {
		int[] lis = new int[boxes.length];
		for (int i = 0; i < lis.length; i++) lis[i] = 1;
		for (int i = 1; i < boxes.length; i++) {
			int maxBefore = 0;
			for (int j = 0; j < i; j++)
				// compare both dimensions
				maxBefore = Math.max(maxBefore,
						boxes[j].weight < boxes[i].weight && boxes[j].vol < boxes[i].vol? lis[j] : 0);
			lis[i] += maxBefore;
		}
		int max = 0;
		for (int i = 0; i < lis.length; i++)
			max = Math.max(max, lis[i]);
		return max;
	}
}
