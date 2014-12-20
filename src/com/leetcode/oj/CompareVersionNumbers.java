package com.leetcode.oj;

/**
 * Created by doliu on 12/18/14.
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if (version1 == null && version2 == null) return 0;
		if (version1 == null) return -1;
		if (version2 == null) return 1;
		if (version1.isEmpty() && version2.isEmpty() || version1.equals(version2)) return 0;
		String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
		int len = Math.max(v1.length, v2.length);
		if (v1.length < len)
			v1 = padding(v1, len);
		else if (v2.length < len)
			v2 = padding(v2, len);
		return compareVersion(v1, 0, v2, 0);
	}

	private String[] padding(String[] v, int len) {
		String[] result = new String[len];
		System.arraycopy(v, 0, result, 0, v.length);
		for (int i = v.length; i < len; i++) result[i] = "0";
		return result;
	}

	private int compareVersion(String[] v1, int s1, String[] v2, int s2) {
		if (s1 >= v1.length && s2 >= v2.length) return 0;
		if (v1[s1].equals(v2[s2])) {
			return compareVersion(v1, s1 + 1, v2, s2 + 1);
		}
		return Integer.valueOf(v1[s1]).compareTo(Integer.valueOf(v2[s2]));
	}
}
