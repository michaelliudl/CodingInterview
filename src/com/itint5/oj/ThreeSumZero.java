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
/*
存放a,b,c的三元组
public class ABC {
  public int a, b, c;
  public ABC(int a, int b, int c) {
    this.a=a;this.b=b;this.c=c;
  }
}
*/

public class ThreeSumZero {
	//返回所有满足条件的(a,b,c)三元组
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
