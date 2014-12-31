package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/25/14.
 */
public class ExcelNumberTest {
	@Test
	public void testExcelNumber() {
		ExcelNumber en = new ExcelNumber();
		Assert.assertEquals(1, en.excelToDec(en.decToExcel(1)));
		Assert.assertEquals(26, en.excelToDec(en.decToExcel(26)));
		Assert.assertEquals(51, en.excelToDec(en.decToExcel(51)));
		Assert.assertEquals(52, en.excelToDec(en.decToExcel(52)));
	}
}
