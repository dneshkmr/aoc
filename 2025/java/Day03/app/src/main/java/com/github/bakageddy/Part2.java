package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Part2 {
	public static void run(String args[]) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String line = null;
		long sum = 0;
		while ((line = br.readLine()) != null) {
			long joltage = new BatteryLine(line).joltage();
			System.out.println(joltage);
			sum += joltage;
		}
		System.out.println(sum);
	}
}

class BatteryLine {
	public static final int WINDOW = 12;
	int[] battery;

	public BatteryLine(String line) {
		battery = new int[line.length()];
		for (int i = 0; i < line.length(); i++) {
			battery[i] = line.charAt(i) - '0';
		}
	}
	// [0, 1, 2, 3, 4, 5, 6]
	// [1, 2, 3, 4, 5, 6, 7]
	public long joltage() {
		int current_index = 0;
		int len = battery.length;
		long joltage = 0;
		for (int i = WINDOW; i > 0; i--) {
			int max_idx = largestDigit(current_index, len - i);
			joltage *= 10;
			joltage += battery[max_idx];
			current_index = max_idx + 1;
		}
		return joltage;
	}

	public int largestDigit(int currentIndex, int end) {
		int max = Integer.MIN_VALUE;
		int max_idx = currentIndex;
		for (int i = currentIndex; i <= end; i++) {
			if (battery[i] > max) {
				max = battery[i];
				max_idx = i;
			}
		}
		return max_idx;
	}
}
