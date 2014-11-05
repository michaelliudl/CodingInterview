package com.leetcode.oj;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doliu on 10/6/14.
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.trim().length() == 0)
			return false;
		String str = s.trim();
		int idxSign = -1, idxDot = -1, idxE = -1;
		Set<Integer> idxNumber = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '+' || str.charAt(i) == '-')
				idxSign = i;
			else if (str.charAt(i) == '.') {
				if (idxDot >= 0) return false;
				idxDot = i;
			} else if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
				if (idxE >= 0) return false;
				idxE = i;
			} else if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
			    idxNumber.add(i);
			else return false;
		}
		if (idxNumber.size() == 0) return false;
		if (idxSign > 0 && idxE < 0) return false;
		if (idxSign > 0 && idxE > 0 && idxSign - idxE != 1) return false;
		if (idxE > 0 && idxDot > idxE) return false;
		if (idxE >= 0) {
			boolean found = false;
			for (int i = 0; i < idxE; i++)
				if (idxNumber.contains(i)) {
					found = true;
					break;
				}
			if (!found) return false;
			found = false;
			for (int i = idxE + 1; i < str.length(); i++)
				if (idxNumber.contains(i)) {
					found = true;
					break;
				}
			if (!found) return false;
		}
		return true;
	}
}
