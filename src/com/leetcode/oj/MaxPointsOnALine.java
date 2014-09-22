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
	public int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length == 1) return 1;
		Map<Line, Set<Point>> lines = new HashMap<>();
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line line = formLine(points[i].x, points[i].y, points[j].x, points[j].y);
				if (lines.containsKey(line)) {
					Set<Point> p = lines.get(line);
					p.add(points[i]);
					p.add(points[j]);
				} else {
					Set<Point> p = new HashSet<>();
					p.add(points[i]);
					p.add(points[j]);
					lines.put(line, p);
				}
				if (lines.get(line).size() > max) max = lines.get(line).size();
			}
		}
		return max;
	}

	private Line formLine(int x1, int y1, int x2, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		if (dx == 0) {
			return new Line(Double.MAX_VALUE, x1);
		} else if (dy == 0) {
			return new Line(0, y1);
		} else {
			double slope = ((double)dy) / dx;
			double intercept = y1 - x1 * slope;
			return new Line(slope, intercept);
		}
	}

	private class Line {
		double slope;
		double intercept;

		Line(double slope, double intercept) {
			this.slope = slope;
			this.intercept = intercept;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Line line = (Line) o;

			if (Double.compare(line.intercept, intercept) != 0) return false;
			if (Double.compare(line.slope, slope) != 0) return false;

			return true;
		}

		@Override
		public int hashCode() {
			int result;
			long temp;
			temp = Double.doubleToLongBits(slope);
			result = (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(intercept);
			result = 31 * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
	}
}
