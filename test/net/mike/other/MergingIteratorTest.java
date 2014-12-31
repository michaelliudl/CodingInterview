package net.mike.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by doliu on 12/20/14.
 */
public class MergingIteratorTest {
	@Test
	public void testMergingIterator() {
		MergingIterator m = new MergingIterator(
				Arrays.asList(Arrays.asList(0,3,9).listIterator(),
						Arrays.asList(5,7,8).listIterator(),
						Arrays.asList(1,2,4).listIterator(),
						Arrays.asList(6).listIterator(),
						Arrays.asList(11,12,13,14,15).listIterator()
				)
		);
		while (m.hasNext()) {
			System.out.println(m.next());
		}
	}

	@Test
	public void testMergingIteratorWithMap() {
		MergingIterator.MergingIteratorWithMap m = new MergingIterator.MergingIteratorWithMap(
				Arrays.asList(Arrays.asList(0,3,9).listIterator(),
						Arrays.asList(5,7,8).listIterator(),
						Arrays.asList(1,2,4).listIterator(),
						Arrays.asList(6).listIterator(),
						Arrays.asList(11,12,13,14,15).listIterator()
				)
		);
		while (m.hasNext()) {
			System.out.println(m.next());
		}
	}
}
