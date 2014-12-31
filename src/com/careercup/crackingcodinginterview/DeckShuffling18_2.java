package com.careercup.crackingcodinginterview;

/**
 * Write a method to shuffle a deck of cards.
 * It must be a perfect shuffle—in other words, each of the 52! permutations of the deck has to be equally likely.
 * Assume that you are given a random number generator which is perfect.
 */

import java.util.Random;

/**
 * This is a very well-known interview question, and a well-known algorithm.
 * If you aren't one of the lucky few to already know this algorithm, read on.
 * Let's imagine our n-element array. Suppose it looks like this:
 * [1] [2] [3] [4] [5]
 * Using our Base Case and Build approach, we can ask this question: suppose we had a method shuffle(...)
 * that worked on n - 1 elements. Could we use this to shuffle n elements?
 * Sure. In fact, that's quite easy. We would first shuffle the first n - 1 elements.
 * Then, we would take the nth element and randomly swap it with an element in the array.That's it!
 */
public class DeckShuffling18_2 {
	public void shuffleArrayRecursively(int[] cards) {
		if (cards == null || cards.length <= 1) return;
		shuffleArrayRecursively(cards, cards.length - 1);
	}

	private void shuffleArrayRecursively(int[] cards, int index) {
		if (index == 0) return;
		shuffleArrayRecursively(cards, index - 1);
		// Math.random() vs Random.nextInt()
		// http://stackoverflow.com/questions/738629/math-random-versus-random-nextintint
		int rand = new Random().nextInt(index);
		swap(cards, rand, index);
	}

	private void swap(int[] cards, int i, int j) {
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}

	public void shuffleArrayIteratively(int[] cards) {
		if (cards == null || cards.length <= 1) return;
		for (int i = 1; i < cards.length; i++) {
			int rand = new Random().nextInt(i);
			swap(cards, rand, i);
		}
	}
}
