package com.leetcode.oj;

/**
 * Created by doliu on 9/15/14.
 */
public class ImplementStrStr {
	public String strStrKMP(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) return null;
		int[] partialMatchTable = calcPartialMatch(needle);
		int partialMatch = 0;
		for (int i = 0; i <= haystack.length() - needle.length();) {
			boolean found = true;
			for (int j = partialMatch, k = i + partialMatch; j < needle.length(); j++, k++) {
				if (haystack.charAt(k) != needle.charAt(j)) {
					if (j > 0) {
						partialMatch = partialMatchTable[j - 1];
						i += j - partialMatch;
					} else {
						partialMatch = 0;
						i++;
					}
					found = false;
					break;
				}
			}
			if (found) return haystack.substring(i);
		}
		return null;
	}
	// calculate longest proper prefix which is also suffix
	private int[] calcPartialMatch(String needle) {
		if (needle.length() == 0) return new int[0];
		int[] table = new int[needle.length()];
		table[0] = 0;
		int len = 0;
		for (int i = 1; i < needle.length(); i++) {
			if (needle.charAt(i) == needle.charAt(len)) {
				table[i] = ++len;
			} else if (len > 0) {
				len = table[len - 1];
				table[i] = len;
			} else {
				table[i] = len = 0;
			}
		}
		return table;
	}

	public String strStrBruteBackTrace(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) return null;
		for (int i = needle.length() - 1; i < haystack.length(); i++) {
			boolean found = true;
			for (int j = i; j > i - needle.length(); j--) {
				if (haystack.charAt(j) != needle.charAt(j - i + needle.length() - 1)) {
					found = false;
					break;
				}
			}
			if (found) return haystack.substring(i - needle.length() + 1);
		}
		return null;
	}

	public String strStrBrute(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length()) return null;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			boolean found = true;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found) {
				return haystack.substring(i);
			}
		}
		return null;
	}
}
