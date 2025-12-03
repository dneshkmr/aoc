package com.github.bakageddy;

import java.util.Optional;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Part2 {
	public static void main(String[] args) throws Exception {
		InputStream stream = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line = br.readLine();
		ArrayList<Range> ranges = Range.parseRanges(line);

		long sum = 0;
		for (Range r : ranges) {
			sum += Range.getInvalidIdSum(r);
		}
		System.out.println(sum);

	}
}

class Range {
	String start;
	String end;

	public Range(String start, String end) {
		this.start = start;
		this.end = end;
	}

	public static long getInvalidIdSum(Range range) {
		long start = Long.parseLong(range.start);
		long end = Long.parseLong(range.end);
		long sum = 0;

		for (long i = start; i <= end; i++) {
			String number = String.valueOf(i);
			Optional<String> something = split(number);
			if (something.isPresent()) {
				sum += i;
				System.out.println(i);
			}
		}
		return sum;
	}

	public static ArrayList<Range> parseRanges(String line) {
		ArrayList<Range> ranges = new ArrayList<>();
		for (String range : line.split(",")) {
			String[] points = range.split("-");
			ranges.addLast(new Range(points[0], points[1]));
		}
		return ranges;
	}

	public static Optional<String> split(String number) {
		int len = number.length();
		for (int i = 2; i <= len; i++) {
			if (len % i != 0) {
				continue;
			}
			ArrayList<String> partitioned = paritition(number, i);
			if (equalPartitions(partitioned)) {
				return Optional.of(number);
			}
		}
		return Optional.empty();
	}

	public static ArrayList<String> paritition(String number, int times) {
		ArrayList<String> accum = new ArrayList<>();
		StringBuffer scratch = new StringBuffer();
		int item_len = Math.ceilDiv(number.length(), times);
		for (int i = 0; i < number.length(); i++) {
			scratch.append(number.charAt(i));
			if (scratch.length() == item_len) {
				accum.addLast(scratch.toString());
				scratch.delete(0, scratch.length());
			}
		}
		return accum;
	}

	public static boolean equalPartitions(ArrayList<String> list) {
		boolean accum = true;
		for (int i = 0; i < list.size() - 1; i++) {
			accum = accum && (list.get(i).equals(list.get(i + 1)));
			if (!accum) {
				return accum;
			}
		}
		return accum;
	}
}
