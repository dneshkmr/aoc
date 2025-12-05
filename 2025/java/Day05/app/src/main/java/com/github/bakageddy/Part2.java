package com.github.bakageddy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.io.BufferedReader;

public class Part2 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("mock.txt");
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

		ArrayList<Range> old = ranges;
		while (true) {
			ArrayList<Range> merged = mergeRanges(ranges);
			if (old.size() == merged.size()) {
				break;
			}
			old = merged;
		}

		System.out.println(countRangeValues(old));
	}

	public static ArrayList<Range> mergeRanges(ArrayList<Range> ranges) {
		ArrayList<Range> result = new ArrayList<>();
		Collections.sort(ranges);
		for (int i = 0; i < ranges.size() - 1; i++) {
			Range current = ranges.get(i);
			for (int j = i + 1; j < ranges.size(); j++) {
				Range next = ranges.get(j);
				if (current.isPresent(next.start) || current.isPresent(next.end) || next.isPresent(current.start) || next.isPresent(current.end)) {
					current.merge(next);
					result.addLast(current);
				}
			}

			result.addLast(current);
		}
		return result;
	}

	public static long countRangeValues(ArrayList<Range> ranges) {
		long count = 0;
		HashSet<Range> seen = new HashSet<>();
		for (Range r : ranges) {
			if (seen.contains(r)) {
				continue;
			}
			count += r.range();
			seen.add(r);
			System.out.println(seen);
		}
		return count;
	}
}
