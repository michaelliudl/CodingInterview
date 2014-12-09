package com.leetcode.oj;

import com.leetcode.oj.beans.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by doliu on 9/4/14.
 */
public class MaxPointsOnALine {
	// line equation general form ax+by+c=0
	// from one point form y-y1=((y2-y1)/(x2-x1))*(x-x1)
	// derives a=y1-y2, b=x2-x1, c=(y2-y1)*x1+(x1-x2)*y1=-a*x1-b*y1
	public int maxPointsLineOriented(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				boolean isVertical = points[i].x == points[j].x;
				int a = points[i].y - points[j].y;
				int b = points[j].x - points[i].x;
				int c = -(a * points[i].x + b * points[i].y);
				int cur = 0;
				for (int k = 0; k < points.length; k++) {
					if (k == i || k == j
							|| (isVertical && points[k].x == points[i].x)
							|| (!isVertical && a * points[k].x + b * points[k].y + c == 0))
						cur++;
				}
				max = Math.max(max, cur);
			}
		}
		return max;
	}

	public int maxPointsPointOriented(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			Map<Double, Integer> slopeCount = new HashMap<>();
			int duplicate = 0;
			for (int j = i + 1; j < points.length; j++) {
				double slope = Double.NEGATIVE_INFINITY;
				if (points[j].x == points[i].x && points[j].y == points[i].y)
					duplicate++;
				else if (points[j].x == points[i].x)
					slope = Double.POSITIVE_INFINITY;
				else
					slope = (1.0D * points[i].y - points[j].y) / (points[i].x - points[j].x);
				if (slope == -0.0D) slope = 0.0D;
				if (slope != Double.NEGATIVE_INFINITY)
					if (slopeCount.containsKey(slope))
						slopeCount.put(slope, slopeCount.get(slope) + 1);
					else
						slopeCount.put(slope, 2);
			}
			if (slopeCount.isEmpty())
				max = Math.max(max, duplicate + 1);
			for (Map.Entry<Double, Integer> entry : slopeCount.entrySet())
				max = Math.max(max, entry.getValue() + duplicate);
		}
		return max;
	}
}
