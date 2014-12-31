package com.careercup.crackingcodinginterview;

/**
 * You have a large text file containing words. Given any two words, find the shortest distance (in terms of number of words) between them in the file.
 * If the operation will be repeated many times for the same file (but different pairs of words), can you optimize your solution?
 */
public class ShortestDistanceOfWordsInFile18_5 {
	// To solve this problem, we can traverse the file just once.
	// We remember throughout our traversal where we've last seen word1 and word2, storing the locations in lastPosWord1 and lastPosWord2.
	// When we come across word1, we compare it to lastPosWord2 and update min as necessary, and then update lastPosWord1.
	// We do the equivalent operation on word2. At the end of the traversal, we will have the minimum distance.
	public int shortest(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1, lastPosWord2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				lastPosWord1 = i;
				if (lastPosWord2 >= 0)
					min = Math.min(min, Math.abs(lastPosWord1 - lastPosWord2));
			} else if (words[i].equals(word2)) {
				lastPosWord2 = i;
				if (lastPosWord1 >= 0)
					min = Math.min(min, Math.abs(lastPosWord1 - lastPosWord2));
			}
		}
		return min;
	}

	// If we need to repeat the operation for other pairs of words, we can create a hash table with each word and the locations where it occurs.
	// We then just need to find the minimum (arithmetic) difference between a value in listA and a value in listB.
	// Scan shorter list and binary search the other list for to be location O(n*lgm)
	// Consider the following lists:
	// listA: {I, 2, 9, IS, 25}
	// listB: {4, 10, 19}
	// We can merge these lists into one sorted list, but"tag"each number with the original list.
	// Tagging can be done by wrapping each value in a class that has two member variables: data (to store the actual value) and listNumber.
	// list: {la, 2a, 4b, 9a, I0b, 15a, I9b, 25a}
	// Finding the minimum distance is now just a matter of traversing this merged list to find the minimum distance between two consecutive numbers which have different list tags.
	// In this case, the solution would be a distance of 1 (between 9a and lOb).
	// After the initial indexing of the file, this takes O(p + k) time, where p and k are the number of occurrences of each word.
}
