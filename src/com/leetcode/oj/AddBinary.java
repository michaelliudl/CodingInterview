package com.leetcode.oj;

import java.math.BigInteger;

/**
 * Created by doliu on 5/10/14.
 */
public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null) return b;
		if (b == null) return a;
		try {
			BigInteger valueA = new BigInteger(a, 2);
			BigInteger valueB = new BigInteger(b, 2);
			return valueA.add(valueB).toString(2);
		} catch (Exception e) {
			return null;
		}
	}
}
