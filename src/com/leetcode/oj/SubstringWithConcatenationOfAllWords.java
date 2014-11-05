package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 10/8/14.
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		if (S == null || L == null || L.length == 0) return Collections.emptyList();
		int m = S.length(), n = L.length, k = L[0].length();
		if (m < n * k) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		Map<String, Integer> words = new HashMap<>();
		for (String s : L) {
			if (words.containsKey(s))
				words.put(s, words.get(s) + 1);
			else words.put(s, 1);
		}
		Map<String, Integer> counter = new HashMap<>();
		for (int i = 0; i <= m - n * k; i++) {
			for (String s : L)
				counter.put(s, 0);
			int j = i;
			for (; j < i + n * k; j += k) {
				String sub = S.substring(j, j + k);
				if (counter.containsKey(sub) && counter.get(sub) < words.get(sub))
					counter.put(sub, counter.get(sub) + 1);
				else
					break;
			}
			if (j == i + n * k)
				result.add(i);
		}
		return result;
	}
}
