package com.github.bakageddy;

public class Range implements Comparable<Range> {
	long start;
	long end;

	public Range(long start, long end) {
		this.start = start;
		this.end = end;
	}

	public static Range parseRange(String line) throws Exception {
		String[] range =  line.split("-");
		long start = Long.parseLong(range[0]);
		long end = Long.parseLong(range[1]);
		return new Range(start, end);
	}

	public long range() {
		return this.end - this.start + 1;
	}

	public boolean isPresent(long number) {
		return number >= this.start && number <= this.end;
	}

	public boolean isEquals(Range other) {
		return this.start >= other.start || this.end <= other.end || this.start <= other.end || this.end >= other.start;
	}

	public void merge(Range other) {
		this.start = Math.min(this.start, other.start);
		this.end = Math.min(this.end, other.end);
	}

	@Override
	public int compareTo(Range o) {
		Range other = o;
		if (this.start == other.start && this.end == other.end) return 0;
		else if (this.start > other.start) return 1;
		else if (this.start < other.start) return -1;
		else return 1;
	}

	public String toString() {
		return this.start + "-" + this.end;
	}
}
