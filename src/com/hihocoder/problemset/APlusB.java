package com.hihocoder.problemset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by doliu on 12/13/14.
 */
public class APlusB {
	public static void main(String[] args) {
		APlusB inst = new APlusB();
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
		int sum = s + e;
		output(new int[] {sum});
	}

	void output(int[] array) {
		System.out.printf("%d\n", array[0]);
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
