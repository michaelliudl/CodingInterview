package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by doliu on 8/26/14.
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
		if (num < 1 || num > 3999) return null;
		Map<Integer, String> hundreds = new HashMap<>();
		hundreds.put(1, "C");
		hundreds.put(2, "CC");
		hundreds.put(3, "CCC");
		hundreds.put(4, "CD");
		hundreds.put(5, "D");
		hundreds.put(6, "DC");
		hundreds.put(7, "DCC");
		hundreds.put(8, "DCCC");
		hundreds.put(9, "CM");
		Map<Integer, String> tens = new HashMap<>();
		tens.put(1, "X");
		tens.put(2, "XX");
		tens.put(3, "XXX");
		tens.put(4, "XL");
		tens.put(5, "L");
		tens.put(6, "LX");
		tens.put(7, "LXX");
		tens.put(8, "LXXX");
		tens.put(9, "XC");
		Map<Integer, String> ones = new HashMap<>();
		ones.put(1, "I");
		ones.put(2, "II");
		ones.put(3, "III");
		ones.put(4, "IV");
		ones.put(5, "V");
		ones.put(6, "VI");
		ones.put(7, "VII");
		ones.put(8, "VIII");
		ones.put(9, "IX");
		StringBuilder sb = new StringBuilder();
		int n = num;
		if (n / 1000 > 0) {
			for (int i = n / 1000; i > 0; i--) sb.append('M');
			n = n % 1000;
		}
		if (n / 100 > 0) {
			sb.append(hundreds.get(n / 100));
			n = n % 100;
		}
		if (n / 10 > 0) {
			sb.append(tens.get(n / 10));
			n = n % 10;
		}
		if (n > 0) {
			sb.append(ones.get(n));
		}
		return sb.toString();
	}
}
