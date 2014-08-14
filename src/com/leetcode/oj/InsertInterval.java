package com.leetcode.oj;

import java.util.ArrayList;

/**
 * Created by doliu on 5/10/14.
 */
public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (newInterval == null) return intervals;
		if (intervals == null || intervals.isEmpty()) {
			intervals = new ArrayList<Interval>();
			intervals.add(newInterval);
		}
		if (newInterval.end < intervals.get(0).start) {
			intervals.add(0, newInterval);
			return intervals;
		}
		if (newInterval.end == intervals.get(0).start) {
			Interval myInterval = new Interval(newInterval.start, intervals.get(0).end);
			intervals.remove(0);
			intervals.add(0, myInterval);
			return intervals;
		}
		int len = intervals.size();
		if (newInterval.start > intervals.get(len - 1).end) {
			intervals.add(newInterval);
			return intervals;
		}
		if (newInterval.start == intervals.get(len - 1).end) {
			Interval myInterval = new Interval(intervals.get(len - 1).start, newInterval.end);
			intervals.remove(len - 1);
			intervals.add(myInterval);
			return intervals;
		}
		for (int i = 0; i < len; i++) {

		}
		return intervals;
	}

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
