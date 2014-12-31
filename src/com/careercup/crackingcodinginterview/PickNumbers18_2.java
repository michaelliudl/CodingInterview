package com.careercup.crackingcodinginterview;

import java.util.Random;

/**
 * Write a method to randomly generate a set of m integers from an array of size n.
 * Each element must have equal probability of being chosen.
 */
public class PickNumbers18_2 {
	// Suppose we have an algorithm that can pull a random set of m elements from an array of size n - 1.
	// How can we use this algorithm to pull a random set of m elements from an array of size n?

	// We can first pull a random set of size m from the first n - 1 elements.
	// Then, we just need to decide if array [n] should be inserted into our subset (which would require pulling out a random element from it).
	// An easy way to do this is to pick a random number k from 0 through n.
	// If k < m, then insert array [n] into subset [k].
	// This will both "fairly" (i.e., with proportional probability) insert array[n] into the subset and "fairly" remove a random element from the subset.
	public int[] pickMFromNRecursively(int[] original, int m) {
		if (original == null || original.length <= m) return original;
		return pickMFromNRecursively(original, m, original.length - 1);
	}

	private int[] pickMFromNRecursively(int[] original, int m, int index) {
		if (index == m - 1) {
			int[] result = new int[m];
			System.arraycopy(original, 0, result, 0, m);
			return result;
		}
		int[] result = pickMFromNRecursively(original, m, index - 1);
		int rand = new Random().nextInt(index);
		if (rand < m) result[rand] = original[index];
		return result;
	}

	public int[] pickMIteratively(int[] original, int m) {
		if (original == null || original.length <= m) return original;
		int[] result = new int[m];
		System.arraycopy(original, 0, result, 0, m);
		for (int i = m; i < original.length; i++) {
			int rand = new Random().nextInt(i);
			if (rand < m) result[rand] = original[i];
		}
		return result;
	}
}
