package com.leetcode.oj;

import com.leetcode.oj.beans.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by doliu on 9/18/14.
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		int cur = 0;
		while (cur < intervals.size()) {
			int start = cur, end = cur + 1;
			int startVal = intervals.get(start).start, endVal = intervals.get(start).end;
			boolean hasOverlap = false;
			for (; end < intervals.size(); end++) {
				if (intervals.get(end).start > endVal) break;
				else if (intervals.get(end).end <= endVal) {
					hasOverlap = true;
				} else {
					hasOverlap = true;
					endVal = intervals.get(end).end;
				}
			}
			if (hasOverlap) {
				Interval enclosing = new Interval(startVal, endVal);
				for (int i = end - start; i > 0; i--) {
					intervals.remove(start);
				}
				intervals.add(start, enclosing);
				cur = start + 1;
			} else {
				cur++;
			}
		}
		return intervals;
	}
}
