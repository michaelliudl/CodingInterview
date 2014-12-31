package com.itint5.oj;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by doliu on 12/20/14.
 */
public class StringMatchTest {
	@Test
	public void testStringMatch() {
		StringMatch sm = new StringMatch();
		String str = "rellnmpapqfwkhopkmco";
		sm.initWithString(str);
		Assert.assertEquals(str.contains("hnwnk"), sm.existSubString("hnwnk"));
		Assert.assertEquals(str.contains("e"), sm.existSubString("e"));
		Assert.assertEquals(str.contains("hsqmgbbuq"), sm.existSubString("hsqmgbbuq"));
		Assert.assertEquals(str.contains("ljjivswmd"), sm.existSubString("ljjivswmd"));
		Assert.assertEquals(str.contains("q"), sm.existSubString("q"));
		Assert.assertEquals(str.contains("bx"), sm.existSubString("bx"));
		Assert.assertEquals(str.contains("xmvtr"), sm.existSubString("xmvtr"));
		Assert.assertEquals(str.contains("bljptnsn"), sm.existSubString("bljptnsn"));
		Assert.assertEquals(str.contains("wzqf"), sm.existSubString("wzqf"));
		Assert.assertEquals(str.contains("mafadrrwso"), sm.existSubString("mafadrrwso"));
		Assert.assertEquals(str.contains("sbcnuv"), sm.existSubString("sbcnuv"));
		Assert.assertEquals(str.contains("hffbsaq"), sm.existSubString("hffbsaq"));
		Assert.assertEquals(str.contains("wp"), sm.existSubString("wp"));
		Assert.assertEquals(str.contains("relln"), sm.existSubString("relln"));
		Assert.assertEquals(str.contains("nmpap"), sm.existSubString("nmpap"));
		Assert.assertEquals(str.contains("opkmco"), sm.existSubString("opkmco"));
		Assert.assertEquals(str.contains("kmco"), sm.existSubString("kmco"));
		Assert.assertEquals(str.contains("wkhopkmc"), sm.existSubString("wkhopkmc"));
		Assert.assertEquals(str.contains("mpapqfwkho"), sm.existSubString("mpapqfwkho"));
		Assert.assertEquals(str.contains("kmc"), sm.existSubString("kmc"));

	}
}
