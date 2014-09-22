package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 9/18/14.
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		if (words == null || words.length == 0) return Collections.emptyList();
		if (L <= 0) return Arrays.asList("");
		List<String> result = new ArrayList<>();
		int startForLine = 0;
		while (startForLine < words.length) {
			int end = startForLine;
			int len = 0;
			while (end < words.length && len < L) {
				if (end == startForLine) len += words[end].length();
				else len += (words[end].length() + 1);
				if (len == L) break;
				else if (len < L) end++;
				else {
					end--;
					break;
				}
			}
			if (end >= words.length) end = words.length - 1;
			result.add(justify(words, startForLine, end, L));
			startForLine = end + 1;
		}
		return result;
	}

	private String justify(String[] words, int start, int end, int lineLen) {
		StringBuilder sb = new StringBuilder();
		if (end == words.length - 1) { // last line
			for (int i = start; i <= end; i++) {
				if (i == start) sb.append(words[i]);
				else sb.append(" ").append(words[i]);
			}
			while (sb.length() < lineLen) sb.append(" ");
		} else {
			int sumWordsLen = 0;
			for (int i = start; i <= end; i++) sumWordsLen += words[i].length();
			int totalSpaces = lineLen - sumWordsLen, separations = end - start;
			if (separations == 0) {
				sb.append(words[start]);
				while (sb.length() < lineLen) sb.append(" ");
			} else {
				int avgSpaces = totalSpaces / separations, extraSpaces = totalSpaces % separations;
				for (int i = start; i <= end; i++) {
					if (i == end) sb.append(words[i]);
					else {
						sb.append(words[i]);
						for (int j = avgSpaces; j > 0; j--) sb.append(" ");
						if (extraSpaces > 0) {
							sb.append(" ");
							extraSpaces--;
						}
					}
				}
			}
		}
		return sb.toString();
	}
}
