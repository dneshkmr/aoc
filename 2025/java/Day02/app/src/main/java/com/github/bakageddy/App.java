package com.github.bakageddy;

// import java.io.BufferedReader;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws Exception {
		// InputStream input = App.class.getClassLoader().getResourceAsStream("input.txt");
		// BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		//
		// String line = reader.readLine();
		// ArrayList<Range> result = Range.parseRanges(line);
		// System.out.println(Range.isSymmetricNumber(220220));
		// long sum = sumInvalidIds(result);
		// System.out.println(sum);
	}

	// public static long sumInvalidIds(ArrayList<Range> ranges) {
	// 	long sum = 0;
	// 	// System.out.println(ranges);
	// 	// for (Range range : ranges) {
	// 	// 	for (long start = range.start; start <= range.end; start++) {
	// 	// 		if (Range.isSymmetricNumber(start)) {
	// 	// 			System.out.println(start);
	// 	// 			sum += start;
	// 	// 		}
	// 	// 	}
	// 	// }
	// 	return sum;
	// }
}

// class Range {
// 	public long start;
// 	public long end;
// 	public static ArrayList<Range> parseRanges(String input) {
// 		String[] values = input.split(",");
// 		ArrayList<Range> ranges = new ArrayList<>();
// 		for (var value : values) {
// 			String[] range = value.split("-");
// 			long a = Long.parseLong(range[0]);
// 			long b = Long.parseLong(range[1]);
// 			ranges.addLast(new Range(a, b));
// 		}
// 		return ranges;
// 	}
//
// 	public static boolean isSymmetricNumber(long a) {
// 		Pair<Long> pair = split(a);
// 		if (pair != null) {
// 			return pair.a.equals(pair.b);
// 		} else {
// 			return false;
// 		}
// 	}
//
// 	public static long noOfDigits(long a) {
// 		return (long) Math.floor(Math.log10(a)) + 1;
// 	}
//
// 	public static Pair<Long> split(long a) {
// 		long len = noOfDigits(a);
// 		if (len % 2 != 0) return null;
// 		long splitter = (long) Math.pow(10, len / 2);
// 		long first = Math.floorDiv(a, (long) (splitter));
// 		long second = a % splitter;
// 		return new Pair<>(first, second);
// 	}
//
//
// 	public Range(long a, long b) {
// 		this.start = a;
// 		this.end = b;
// 	}
//
// 	public String toString() {
// 		return "" + this.start + "-" + this.end;
// 	}
// }
//
// class Pair<T> {
// 	public T a;
// 	public T b;
// 	public Pair(T a, T b) {
// 		this.a = a;
// 		this.b = b;
// 	}
//
// 	@Override
// 	public String toString() {
// 		return "" + a.toString() + " " + b.toString();
// 	}
// }
