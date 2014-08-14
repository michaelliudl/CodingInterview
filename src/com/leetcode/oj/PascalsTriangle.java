package com.leetcode.oj;

import java.util.ArrayList;

/**
 * Created by doliu on 5/13/14.
 */
public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		if (numRows <= 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			return result;
		}
		if (numRows == 1) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			ArrayList<Integer> numbers = new ArrayList<>();
			numbers.add(1);
			result.add(numbers);
			return result;
		}
		if (numRows == 2) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			ArrayList<Integer> numbers = new ArrayList<>();
			numbers.add(1);
			result.add(numbers);
			numbers = new ArrayList<>();
			numbers.add(1);
			numbers.add(1);
			result.add(numbers);
			return result;
		}
		ArrayList<ArrayList<Integer>> result = generate(numRows - 1);
		ArrayList<Integer> prevLast = result.get(result.size() - 1);
		ArrayList<Integer> last = new ArrayList<>();
		last.add(1);
		for (int i = 0, n = prevLast.size(); i < n - 1; i++) {
			last.add(prevLast.get(i) + prevLast.get(i + 1));
		}
		last.add(1);
		result.add(last);
		return result;
	}
}
