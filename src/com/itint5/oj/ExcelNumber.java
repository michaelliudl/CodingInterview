package com.itint5.oj;

/**
 * Created by doliu on 12/25/14.
 */
// Excel数转换
public class ExcelNumber {

	private static final String CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	//将十进制数转换为excel数
	public String decToExcel(int decNum) {
		if (decNum <= 0) return "";
		int n = decNum;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int d = n / CHAR.length(), r = n % CHAR.length();
			if (r == 0) {
				sb.append(CHAR.charAt(CHAR.length() - 1));
				n = d - 1;
			} else {
				sb.append(CHAR.charAt(r - 1));
				n = d;
			}
		}
		return sb.reverse().toString();
	}

	//将excel数转换为十进制数
	public int excelToDec(String excelNum) {
		if (excelNum == null || excelNum.isEmpty()) return 0;
		int sum = 0;
		for (int i = 0; i < excelNum.length(); i++) {
			sum = sum * CHAR.length() + CHAR.indexOf(excelNum.charAt(i)) + 1;
		}
		return sum;
	}
}
