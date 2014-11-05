package com.leetcode.oj;

/**
 * Created by doliu on 10/8/14.
 */
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) return null;
		if (num1.equals("0") || num2.equals("0")) return "0";
		int len1 = num1.length(), len2 = num2.length();
		int[] n1 = new int[len1], n2 = new int[len2], result = new int[len1 + len2];
		for (int i = 0; i < result.length; i++)
			result[i] = -1;
		for (int i = len1 - 1; i >= 0; i--)
			n1[len1 - 1 - i] = num1.charAt(i) - '0';
		for (int i = len2 - 1; i >= 0; i--)
			n2[len2 - 1 - i] = num2.charAt(i) - '0';
		for (int i = 0; i < len1; i++)
			for (int j = 0; j < len2; j++) {
				int old = result[i + j] < 0 ? 0 : result[i + j];
				int product = old + n1[i] * n2[j];
				int carry = product / 10;
				if (carry > 0) {
					if (result[i + j + 1] < 0)
						result[i + j + 1] = 0;
					result[i + j + 1] += carry;
				}
				result[i + j] = product % 10;
			}
		int last = result.length - 1;
		while (result[last] < 0) last--;
		StringBuilder sb = new StringBuilder();
		for (int i = last; i >= 0; i--)
			sb.append(result[i]);
		return sb.toString();
	}

	public String multiplyBigInteger(String num1, String num2) {
		if (num1 == null || num2 == null) return null;
		java.math.BigInteger n1 = new java.math.BigInteger(num1);
		java.math.BigInteger n2 = new java.math.BigInteger(num2);
		return n1.multiply(n2).toString();
	}
}
