package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.OptionalLong;
import java.util.Arrays;

public class Part1 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part1.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = br.readLine();
		MathHomework homework = new MathHomework();
		while (line != null) {
			String[] nums = line.split(" ");
			for (String num : nums) {
				OptionalLong val = tryParse(num);
				if (val.isEmpty()) {
					homework.appendOperator(num);
				} else {
					homework.appendOperand(val.getAsLong());
				}
			}
			line = br.readLine();
		}

		long[] result = homework.finishHomework();
		long sum = 0;
		for (long num : result) {
			sum += num;
		}
		System.out.println(sum);
		br.close();
		in.close();
		return; 
	}

	public static OptionalLong tryParse(String buf) {
		try {
			long val = Long.parseLong(buf);
			return OptionalLong.of(val);
		} catch (NumberFormatException e) {
			return OptionalLong.empty();
		}
	}
}
