package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Part1 {
	public static void run(String[] args) throws Exception {
		// InputStream in =  Part1.class.getClassLoader().getResourceAsStream("input.txt");
		// BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// String line = null;
		// int sum = 0;
		// while ((line = br.readLine()) != null) {
		// 	int joltage = new BatteryLine(line).joltage();
		// 	System.out.println(joltage);
		// 	sum += joltage;
		// }
		// System.out.println(sum);
	}
}

// class BatteryLine {
// 	int[] battery;
//
// 	public BatteryLine(String line) {
// 		battery = new int[line.length()];
// 		for (int i = 0; i < line.length(); i++) {
// 			battery[i] = line.charAt(i) - '0';
// 		}
// 	}
//
// 	public int joltage() {
// 		int joltage = Integer.MIN_VALUE;
// 		for (int i = 0; i < battery.length - 1; i++) {
// 			int temp = battery[i] * 10;
// 			temp += maxValue(i + 1).b;
//
// 			if (temp >= joltage) {
// 				joltage = temp;
// 			}
// 		}
// 		return joltage;
// 	}
//
// 	public Tuple<Integer> maxValue(int idx) {
// 		int maxValue = Integer.MIN_VALUE;
// 		int maxIdx = idx;
// 		for (int i = idx; i < battery.length; i++) {
// 			if (battery[i] > maxValue) {
// 				maxValue = battery[i];
// 				maxIdx = i;
// 			}
// 		}
// 		return new Tuple<>(maxIdx, maxValue);
// 	}
//
// 	public String toString() {
// 		return Arrays.toString(battery);
// 	}
// }
//
// class Tuple<T> {
// 	T a;
// 	T b;
//
// 	public Tuple(T a, T b) {
// 		this.a = a;
// 		this.b = b;
// 	}
// }
