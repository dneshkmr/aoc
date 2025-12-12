package com.github.bakageddy;

import java.util.ArrayList;
import java.util.Optional;
import java.util.HashMap;

public class Manifold {
	public ArrayList<char[]> grid;
	public HashMap<Point, Long> cache;
	public Manifold() {
		this.grid = new ArrayList<>();
		this.cache = new HashMap<>();
	}

	public void appendLine(String line) {
		this.grid.addLast(line.toCharArray());
	}

	public Optional<Point> findSource() {
		char[] sourceLayer = grid.get(0);
		for (int i = 0; i < sourceLayer.length; i++) {
			if (sourceLayer[i] == 'S') {
				return Optional.of(new Point(i, 0));
			}
		}
		return Optional.empty();
	} 

	public Optional<Long> getTimelineCount() {
		Optional<Point> maybeSource = findSource();
		if (maybeSource.isEmpty()) {
			return Optional.empty();
		}

		Point source = maybeSource.get(); 
		long count = helper(source);
		return Optional.of(count);
	} 

	private long helper(Point source) {
		if (cache.containsKey(source)) {
			return cache.get(source);
		}

		int row_len = grid.get(0).length;
		if (source.y == grid.size()) {
			return 0;
		}

		long count = 0;
		int i;
		for (i = source.y; i < grid.size(); i++) {
			if (grid.get(i)[source.x] == '^') {
				break;
			}
		}

		if (i == grid.size()) {
			return 1;
		}

		if (source.x != 0) {
			count += helper(new Point(source.x - 1, i));
		}

		if (source.x != row_len - 1) {
			count += helper(new Point(source.x + 1, i));
		}

		cache.putIfAbsent(source, count);
		return count;
	}
}
