package com.lintcode.oj;

import java.math.BigInteger;

/**
 * Created by doliu on 12/12/14.
 */
@Deprecated
// overflowing long
public class HashFunction {
	public int hashCode(char[] key,int HASH_SIZE) {
		// write your code here
		if (key == null || key.length == 0 || HASH_SIZE <= 0) return -1;
		String magic = "33";
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < key.length; i++) {
			sum.multiply(new BigInteger(magic)).add(new BigInteger(String.valueOf(((int)key[i]))));
		}
		return sum.mod(new BigInteger(String.valueOf(HASH_SIZE))).intValue();
	}
}
