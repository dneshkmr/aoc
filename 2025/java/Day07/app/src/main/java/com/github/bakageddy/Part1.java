package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class Part1 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part1.class.getClassLoader().getResourceAsStream("input.txt");
		InputStreamReader rdr = new InputStreamReader(in); 
		BufferedReader br = new BufferedReader(rdr);
		String l = null;
		Manifold grid = new Manifold();

		while ((l = br.readLine()) != null) {
			grid.appendLine(l);
		}

		Optional<Point> maybeSource = grid.findSource();
		if (maybeSource.isEmpty()) {
			System.out.println("Cannot find manifold source");
			System.exit(1);
		}

		Point source = maybeSource.get();
		grid.grid.get(0)[source.x] = '|';
		int count = 0;
		for (int i = 1; i < grid.grid.size(); i++) {
			char[] line = grid.grid.get(i);
			char[] prev = grid.grid.get(i - 1);
			for (int j = 0; j < line.length; j++) {
				if (line[j] == '^' && prev[j] == '|') {
					if (j != 0) {
						line[j - 1] = '|';
					}
					if (j != line.length - 1) {
						line[j + 1] = '|';
					}
					count += 1;
				} else if (prev[j] == '|') {
					line[j] = '|';
				}
			}
		}

		System.out.println(count);
	}
}

