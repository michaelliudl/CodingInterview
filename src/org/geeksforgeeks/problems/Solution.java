package org.geeksforgeeks.problems;

/**
 * Created by doliu on 11/12/14.
 */
public class Solution {
	public static void main(String[] args) {
//		twoBases();
		oneMillion();
	}

	private static void twoBases() {
		for (int x = 0; x <= 9; x++) {
			for (int y = 0; y <= 9; y++) {
				for (int z = 0; z <= 9; z++) {
					if (x * 100 + y * 10 + z == z * 81 + y * 9 + x) {
						System.out.printf("%d %d %d\n", x, y, z);
					}
				}
			}
		}
	}

	private static void oneMillion() {
		int target = 1000000;
		for (int i = 1; i <= target; i++) {
			if (target % i == 0 && !String.valueOf(i).contains("0") && !String.valueOf(target / i).contains("0"))
				System.out.printf("%d %d\n", i, target / i);
		}
	}
}
