package com.leetcode.oj;

/**
 * Created by doliu on 10/8/14.
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		int sn = s.length(), pn = p.length();
		if (sn == 0 && pn == 0) return true;
		if (sn == 0 || pn == 0) return false;
		int i = 0, j = 0;
		while (i < sn && j < pn) {
			if (j < pn - 1 && p.charAt(j + 1) == '*') {
				if (p.charAt(j) == '.') {
					i = sn;
					j += 2;
				} else {
					if (s.charAt(i) == p.charAt(j))
						i++;
					else j += 2;
				}
			} else if (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')
				return false;
			else {
				i++;
				j++;
			}
		}
		if (i == sn && j == pn) return true;
		if (i < sn && j == pn) return false;
		if (i == sn && j < pn - 1) {
			int lastStar = pn - 1;
			while (lastStar > 0 && p.charAt(lastStar) != '*')
				lastStar--;
			if (lastStar <= 0)
				return false;
			boolean tailMatch = true;
			for (int k = pn - 1; k > lastStar; k--) {
				int diff = pn - 1 - k;
				if (p.charAt(k) != s.charAt(sn - 1 - diff)) {
					tailMatch = false;
					break;
				}
			}
			return tailMatch;
		}
		return false;
	}
}
