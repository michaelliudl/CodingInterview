package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 10/2/14.
 */
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		if (strs == null || strs.length == 0) return Collections.emptyList();
		Map<String, List<String>> cache = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = new String(c);
			if (cache.containsKey(sorted))
				cache.get(sorted).add(s);
			else {
				List<String> strings = new ArrayList<>();
				strings.add(s);
				cache.put(sorted, strings);
			}
		}
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : cache.entrySet())
			if (entry.getValue().size() > 1)
				result.addAll(entry.getValue());
		return result;
	}
}
