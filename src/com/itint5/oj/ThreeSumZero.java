package com.itint5.oj;

import beans.ABC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by doliu on 12/22/14.
 */
// 三数和为0
public class ThreeSumZero {
	// 返回所有满足条件的(a,b,c)三元组
	// 空间复杂度O(1)的算法(不使用任何辅助空间)，没必要利用set等数据结构消除重复的三元组
	// check if arr[j] == arr[j - 1] or arr[k] == arr[k + 1] to detect duplicate triplets
	public List<ABC> threeSumZero(int[] arr) {
		if (arr == null || arr.length < 3) return Collections.emptyList();
		Arrays.sort(arr);
		List<ABC> result = new ArrayList<>();
		for (int i = 0; i <= arr.length - 3; i++) {
			if (i > 0 && arr[i] == arr[i - 1])
				continue;
			int j = i + 1, k = arr.length - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == 0) {
					if (j == i + 1 || k == arr.length - 1 || (j > i + 1 && arr[j] != arr[j - 1])
							|| (k < arr.length - 1 && arr[k] != arr[k + 1])) {
						ABC candidate = new ABC(arr[i], arr[j], arr[k]);
						result.add(candidate);
					}
					j++;
					k--;
				} else if (sum < 0)
					j++;
				else k--;
			}
		}
		return result;
	}
}
