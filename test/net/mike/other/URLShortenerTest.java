package net.mike.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Created by doliu on 12/14/14.
 */
public class URLShortenerTest {

	private URLShortener us = new URLShortener();

	@Test
	public void testToShortForm() {
		int id = new Random().nextInt(Integer.MAX_VALUE);
		Assert.assertEquals(id, us.toId(us.toShortForm(id)));
	}
}
