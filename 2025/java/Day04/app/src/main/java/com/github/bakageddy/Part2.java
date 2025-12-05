package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Part2 {
	public static void run(String args[]) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		Grid grid = new Grid();
		while ((line = br.readLine()) != null) {
			grid.appendRow(Grid.parseLine(line));
		}

		int removed_count = 0;
		long unreachable_count = 0;
		while ((unreachable_count = grid.countUnreachable()) != 0) {
			grid.removeUnreachable();
			removed_count += unreachable_count;
		}

		System.out.println(removed_count);
	}
}

class Grid {
	ArrayList<boolean[]> grid;

	public Grid() {
		grid = new ArrayList<>();
	}

	public void appendRow(boolean[] line) {
		grid.addLast(line);
	}

	public int countUnreachable() {
		int row_len = grid.size();
		int col_len = grid.get(0).length;

		int count = 0;
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				if (grid.get(i)[j]) {
					int neighbours = this.getNeighbourCount(i, j);
					if (neighbours <= 4) {
						count += 1;
					}
				}
			}
		}
		return count;
	}

	public void removeUnreachable() {
		int row_len = grid.size();
		int col_len = grid.get(0).length;

		HashSet<Integer> removePos = new HashSet<>();
		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				if (grid.get(i)[j]) {
					int neighbours = this.getNeighbourCount(i, j);
					if (neighbours <= 4) {
						removePos.add(i * row_len + j);
					}
				}
			}
		}

		for (int i = 0; i < row_len; i++) {
			for (int j = 0; j < col_len; j++) {
				int pos = i * row_len + j;
				if (removePos.contains(pos)) {
					grid.get(i)[j] = false;
				}
			}
		}
	}

	public int getNeighbourCount(int row, int col) {
		int row_start = row == 0 ? row : row - 1;
		int row_end = row == grid.get(0).length - 1 ? row : row + 1;
		int col_start = col == 0 ? col : col - 1;
		int col_end = col == grid.size() - 1 ? col : col + 1;

		int count = 0;
		for (int i = row_start; i <= row_end; i++) {
			for (int j = col_start; j <= col_end; j++) {
				if (grid.get(i)[j])
					count++;
			}
		}
		return count;
	}

	public static boolean[] parseLine(String line) {
		boolean[] ints = new boolean[line.length()];
		for (int i = 0; i < line.length(); i++) {
			ints[i] = line.charAt(i) == '@';
		}
		return ints;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < grid.size(); i++) {
			buf.append(Arrays.toString(grid.get(i)));
			buf.append("\n");
		}
		return buf.toString();
	}
}
