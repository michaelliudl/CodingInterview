package org.uva.oj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 12/13/14.
 */
class ThreeNPlusOne {
	public static void main(String[] args) {
		ThreeNPlusOne inst = new ThreeNPlusOne();
		inst.solve();
	}

	void solve() {
		List<String> input = readInput();
		solve(input);
	}

	void solve(List<String> input) {
		for (String str : input) {
			solve(str);
		}
	}

	void solve(String input) {
		String[] splitted = input.split(" ");
		if (splitted.length != 2) return;
		int s = Integer.parseInt(splitted[0]), e = Integer.parseInt(splitted[1]);
		int maxCycle = findMaxCycle(s, e);
		output(new int[] {s, e, maxCycle});
	}

	void output(int[] array) {
		System.out.printf("%d %d %d\n", array[0], array[1], array[2]);
	}

	int findMaxCycle(int s, int e) {
		int max = 0;
		for (int i = s; i <= e; i++) {
			int cycle = findCycle(i);
			max = Math.max(max, cycle);
		}
		return max;
	}

	int findCycle(int n) {
		int cycle = 1;
		while (n != 1) {
			cycle++;
			if (n % 2 == 1) n = 3 * n + 1;
			else n /= 2;
		}
		return cycle;
	}

	List<String> readInput() {
		List<String> input = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			while (line != null && line.length() > 0) {
				input.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			return input;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
}
