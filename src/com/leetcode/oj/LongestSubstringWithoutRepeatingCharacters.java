package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 8/28/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		Map<String, Integer> charPos = new HashMap<>();
		int p = 0, len = 0, max = 0;
		while (p < s.length()) {
			String ch = String.valueOf(s.charAt(p));
			if (charPos.containsKey(ch)) {
				p = charPos.get(ch) + 1;
				len = 0;
				charPos.clear();
			} else {
				charPos.put(ch, p);
				p++;
				len++;
				if (len > max) max = len;
			}
		}
		return max;
	}
}
