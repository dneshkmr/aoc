package com.github.bakageddy;

import java.util.ArrayList;
import java.util.Optional;

public class Manifold {
	public ArrayList<char[]> grid;
	public Manifold() {
		this.grid = new ArrayList<>();
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

	public long getPathCount() {

		return 0;
	} 
}
