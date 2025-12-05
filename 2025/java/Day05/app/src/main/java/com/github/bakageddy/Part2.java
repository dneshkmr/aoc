package com.github.bakageddy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.io.BufferedReader;

public class Part2 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		ArrayList<Range> ranges = new ArrayList<>();
		while (true) {
			line = br.readLine();
			if (line == null || "".equals(line)) {
				break;
			}
			ranges.addLast(Range.parseRange(line));
		}

		ArrayList<Range> result = mergeRanges(ranges);
		System.out.println(countRangeValues(result));
	}

	public static ArrayList<Range> mergeRanges(ArrayList<Range> ranges) {
		ArrayList<Range> result = new ArrayList<>();
		Collections.sort(ranges);
		Range prev = ranges.get(0);

		for (int i = 1; i < ranges.size(); i++) {
			Range r = ranges.get(i);
			if (r.start <= prev.end) {
				prev.merge(r);
			} else {
				result.add(prev);
				prev = r;
			}
		}

		result.add(prev); // Don't forget this
		return result;
	}

	public static long countRangeValues(ArrayList<Range> ranges) {
		long count = 0;
		for (Range r : ranges) {
			count += r.range();
		}
		return count;
	}
}
