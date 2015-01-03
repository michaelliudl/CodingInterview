package com.lintcode.oj;

/**
 * Created by doliu on 12/13/14.
 */
public class BinarySearch {
	/**
	 * @param nums: The integer array.
	 * @param target: Target to find.
	 * @return: The first position of target. Position starts from 0.
	 */
	public int binarySearch(int[] nums, int target) {
		//write your code here
		if (nums == null || nums.length == 0) return -1;
		int s = 0, e = nums.length - 1;
		while (s <= e) {
			if (s == e) {
				if (nums[s] == target)
					return findFirst(nums, s, target);
				else return -1;
			}
			int mid = (s + e) / 2;
			if (nums[mid] == target) {
				return findFirst(nums, mid, target);
			}
			else if (nums[mid] < target) s = mid + 1;
			else e = mid - 1;
		}
		return -1;
	}

	private int findFirst(int[] nums, int pos, int target) {
		for (int i = pos - 1; i >= 0; i--) {
			if (nums[i] != target) return i + 1;
		}
		return 0;
	}
}
