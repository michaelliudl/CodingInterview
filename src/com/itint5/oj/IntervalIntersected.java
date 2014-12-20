package com.itint5.oj;

import beans.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 12/14/14.
 */
public class IntervalIntersected {

	// intervals包含n个区间
	// 结果存放到isIntersected中(已分配空间)
	// isIntersected[i]表示第i个区间是否与其它区间相交

	public void intersected(Interval[] intervals, boolean[] isIntersected) {
		if (intervals == null || isIntersected == null || intervals.length != isIntersected.length)
			return;
		for (int i = 0; i < intervals.length; i++) {
			if (!isIntersected[i]) {
				for (int j = 0; j < i; j++) {
					if (intersected(intervals[i], intervals[j])) {
						isIntersected[i] = isIntersected[j] = true;
						break;
					}
				}
				if (!isIntersected[i]) {
					for (int j = i + 1; j < intervals.length; j++) {
						if (intersected(intervals[i], intervals[j])) {
							isIntersected[i] = isIntersected[j] = true;
							break;
						}
					}
				}
			}
		}
	}

	private boolean intersected(Interval interval1, Interval interval2) {
		if (interval1.start > interval2.start)
			return intersected(interval2, interval1);
		return interval2.start <= interval1.end;
	}

	@Deprecated
	// NOT working
	public void intersectedSort(Interval[] intervals, boolean[] isIntersected) {
		if (intervals == null || isIntersected == null || intervals.length != isIntersected.length)
			return;
		if (intervals.length == 1) {
			isIntersected[0] = false;
			return;
		}
		Map<Interval, Integer> map = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i], i);
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 0; i < intervals.length; i++) {
			if (i == 0) {
				isIntersected[map.get(intervals[i])] = intervals[i].end >= intervals[i + 1].start;
			} else if (i == intervals.length - 1) {
				isIntersected[map.get(intervals[i])]
						= intervals[i].start <= intervals[i - 1].end;
			} else {
				isIntersected[map.get(intervals[i])] =
						intervals[i].start <= intervals[i - 1].end || intervals[i].end >= intervals[i + 1].start;
			}
		}
	}
}
