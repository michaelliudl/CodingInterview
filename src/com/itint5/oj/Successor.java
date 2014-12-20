package com.itint5.oj;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by doliu on 12/14/14.
 */
@Deprecated
// deprecated means problem

public class Successor {

	private TreeSet<Integer> set = new TreeSet<>();

	public void init(int N) {
		if (N > 0) {
			for (int i = 0; i < N; i++)
				set.add(i);
		}
	}

	public void removeNum(int x) {
		set.remove(x);
	}

	public int query(int x) {
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			int cur = iter.next();
			if (cur == x && iter.hasNext()) {
				return iter.next();
			}
		}
		return -1;
	}
}
