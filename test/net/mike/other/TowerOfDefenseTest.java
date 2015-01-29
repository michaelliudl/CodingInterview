package net.mike.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by doliu on 1/9/15.
 */
public class TowerOfDefenseTest {
	@Test
	public void testCalculateCost() {
		TowerOfDefense tower = new TowerOfDefense(4, 5, null, new Coordinate(2, 3));
		tower.calculate();
		Assert.assertArrayEquals(
				new int[][] {{5,4,3,2,3},{4,3,2,1,2},{3,2,1,0,1},{4,3,2,1,2}},
				tower.getCost());

		tower = new TowerOfDefense(4, 5,
				Arrays.asList(new Coordinate(1, 1), new Coordinate(0, 4), new Coordinate(2, 0), new Coordinate(3, 1)),
				new Coordinate(2, 3));
		tower.calculate();
		Assert.assertArrayEquals(
				new int[][]{{5, 4, 3, 2, -1}, {6, -1, 2, 1, 2}, {-1, 2, 1, 0, 1}, {0, -1, 2, 1, 2}},
				tower.getCost());
	}
}
