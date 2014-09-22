package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/21/14.
 */
public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) return Arrays.asList("");
		Map<String, List<String>> map = new HashMap<>();
		map.put("1", Arrays.asList(""));
		map.put("2", Arrays.asList("a", "b", "c"));
		map.put("3", Arrays.asList("d", "e", "f"));
		map.put("4", Arrays.asList("g", "h", "i"));
		map.put("5", Arrays.asList("j", "k", "l"));
		map.put("6", Arrays.asList("m", "n", "o"));
		map.put("7", Arrays.asList("p", "q", "r", "s"));
		map.put("8", Arrays.asList("t", "u", "v"));
		map.put("9", Arrays.asList("w", "x", "y", "z"));
		return letterCombinations(digits, map);
	}

	private List<String> letterCombinations(String digits, Map<String, List<String>> map) {
		if (digits.length() == 1) return map.get(digits);
		List<String> first = map.get(digits.substring(0, 1));
		List<String> rest = letterCombinations(digits.substring(1), map);
		List<String> all = new ArrayList<>(first.size() * rest.size());
		for (String f : first)
			for (String r : rest)
				all.add(f + r);
		return all;
	}
}
