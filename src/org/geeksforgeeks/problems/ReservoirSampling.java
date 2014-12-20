package org.geeksforgeeks.problems;

import java.io.InputStream;
import java.util.Random;

/**
 * Created by doliu on 12/14/14.
 */
public class ReservoirSampling {

	public int[] reservoirSampling(int[] input, int k) {
		if (input == null || input.length == 0 || k <= 0) return null;
		int[] sample = new int[k];
		int n = input.length;
		for (int i = 0; i < (n > k ? k : n); i++) {
			sample[i] = input[i];
		}
		if (n > k) {
			for (int i = k; i < n; i++) {
				int rand = new Random().nextInt(i);
				if (rand >= 0 && rand < k) {
					sample[rand] = input[i];
				}
			}
		}
		return sample;
	}
}
