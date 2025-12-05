package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Part1 {
	public static void run(String[] args) throws Exception {
		InputStream source = Part1.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader buf = new BufferedReader(new InputStreamReader(source));
		String line = buf.readLine();
		HashSet<Range> set = new HashSet<>();
		while (true) {
			if (line.equals("")) break;
			Range range = Range.parseRange(line);
			set.add(range);
			line = buf.readLine();
		}

		String raw = null;
		int count = 0;
		while ((raw = buf.readLine()) != null) {
			long number = Long.parseLong(raw);
			for (Range range : set) {
				if (range.isPresent(number)) {
					count++;
					break;
				}
			}
			System.out.println(number);
		}

		System.out.println(count);
	}
}
