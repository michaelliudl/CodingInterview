package com.leetcode.oj;

/**
 * Created by doliu on 8/26/14.
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) return 0;
		int max = 0;
		for (int start = 0, end = height.length - 1; start < end;) {
			int w = end - start;
			int h = height[start] < height[end] ? height[start] : height[end];
			int area = w * h;
			if (area > max) max = area;
			if (height[start] < height[end]) start++;
			else end--;
		}
		return max;
	}

	public int maxAreaBrute(int[] height) {
		if (height == null || height.length <= 1) return 0;
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int w = j - i, h = height[i] < height[j] ? height[i] : height[j];
				int area = w * h;
				if (area > max) max = area;
			}
		}
		return max;
	}
}
