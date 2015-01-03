package com.itint5.oj;

/**
 * Created by doliu on 1/2/15.
 */
// 非负大整数加法
public class AddNonNegativeInteger {
	//返回a+b的结果
	public String add(String a, String b) {
		if (a == null || a.isEmpty()) return b;
		if (b == null || b.isEmpty()) return a;
		int m = a.length(), n = b.length();
		int i = m - 1, j = n - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (; i >= 0 && j >= 0; i--, j--) {
			int vA = a.charAt(i) - '0', vB = b.charAt(j) - '0';
			int sum = vA + vB + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		for (; i >= 0; i--) {
			int sum = (a.charAt(i) - '0') + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		for (; j >= 0; j--) {
			int sum = (b.charAt(j) - '0') + carry;
			sb.insert(0, sum % 10);
			carry = sum / 10;
		}
		if (carry > 0) sb.insert(0, carry);
		return sb.toString();
	}
}
