package com.itint5.oj;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by doliu on 12/13/14.
 */
public class JobSchedulerTest {
	@Test
	public void testJobSchedule() {
		int n = 5;
		int[] result = new int[n];
		Map<Integer, List<Integer>> deps = new HashMap<>();
		deps.put(1, Arrays.asList(2, 3));
		deps.put(3, Arrays.asList(4));
		new JobScheduler().jobSchedule(deps, n, result);
	}
}
