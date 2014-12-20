package com.itint5.oj;

import beans.Box;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by doliu on 12/14/14.
 */
public class MaxBox {
	public int maxBoxes(Box[] boxes) {
		if (boxes == null) return 0;
		if (boxes.length <= 1) return boxes.length;
		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box o1, Box o2) {
				return o1.vol - o2.vol;
			}
		});
		return 0;
	}
}
