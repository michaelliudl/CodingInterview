package com.leetcode.oj;

import beans.Interval;

import java.util.Arrays;
import java.util.List;

/**
 * Created by doliu on 5/10/14.
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) return intervals;
		if (intervals == null) return Arrays.asList(newInterval);
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		if (newInterval.end < intervals.get(0).start) {
			intervals.add(0, newInterval);
			return intervals;
		}
		int len = intervals.size();
		if (newInterval.start > intervals.get(len - 1).end) {
			intervals.add(newInterval);
			return intervals;
		}

		int newStart = newInterval.start, newEnd = newInterval.end, overlapStart = -1, overlapEnd = -1;
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= newInterval.start && cur.end >= newInterval.end) return intervals;
			else if (overlapStart < 0 && newInterval.end < cur.start) {
				intervals.add(i, newInterval);
				return intervals;
			}
			else if (cur.start >= newInterval.start && cur.end >= newInterval.end && cur.start <= newInterval.end) {
				newEnd = cur.end;
				if (overlapStart < 0) overlapStart = i;
				overlapEnd = i;
			}
			else if (cur.start <= newInterval.start && cur.end >= newInterval.start) {
				newStart = cur.start;
				if (overlapStart < 0) overlapStart = i;
				overlapEnd = i;
			}
			else if (cur.start >= newInterval.start && cur.end <= newInterval.end) {
				if (overlapStart < 0) overlapStart = i;
				overlapEnd = i;
			}
		}

		if (overlapStart >= 0 && overlapEnd >= 0) {
			int end = overlapEnd;
			while (end >= overlapStart) {
				intervals.remove(overlapStart);
				end--;
			}
			Interval finalInternal = new Interval(newStart, newEnd);
			intervals.add(overlapStart, finalInternal);
		}
		return intervals;
	}

}
