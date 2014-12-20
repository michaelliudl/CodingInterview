package com.itint5.oj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by doliu on 12/14/14.
 */
@Deprecated
// timing out
public class StringMatch {

	private Map<Integer, Set<String>> map = new HashMap<>();
	private static final int MAX = 10;

	// 预处理初始化
	public void initWithString(String str) {
		if (str == null || str.length() == 0)
			return;
		int n = Math.max(MAX, str.length());
		for (int i = 1; i <= n; i++) {
			Set<String> strings = new HashSet<>();
			for (int j = 0; j <= str.length() - i; j++) {
				strings.add(str.substring(j, j + i));
			}
			map.put(i, strings);
		}
	}

	// 如果query是str的字串,返回true,否则返回false
	public boolean existSubString(String query) {
		if (query == null || query.length() == 0)
			return false;
		return map.get(query.length()).contains(query);
	}
}
