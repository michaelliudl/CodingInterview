package com.itint5.oj;

import java.util.*;

/**
 * Create sorted list of substrings of lenth 10
 * And binary search for prefix of query
 *
 * Created by doliu on 12/14/14.
 */
//  字符串匹配
public class StringMatch {

	private static final int MAX = 10;

	private List<String> substrings = new ArrayList<>();

	// 预处理初始化
	public void initWithString(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			substrings.add(str.substring(i, i + MAX > str.length() ? str.length() : i + MAX));
		}
		Collections.sort(substrings);
	}

	// 如果query是str的字串,返回true,否则返回false
	public boolean existSubString(String query) {
		if (query == null || query.isEmpty()) return false;
		int start = 0, end = substrings.size() - 1;
		while (start <= end) {
			if (start == end)
				return substrings.get(start).startsWith(query);
			int mid = (start + end) / 2;
			if (substrings.get(mid).startsWith(query))
				return true;
			int comp = substrings.get(mid).compareTo(query);
			if (comp == 0) return true;
			else if (comp < 0) start = mid + 1;
			else end = mid - 1;
		}
		return false;
	}
}
