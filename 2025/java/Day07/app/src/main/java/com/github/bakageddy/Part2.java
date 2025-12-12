package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class Part2 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		InputStreamReader rdr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(rdr);
		String line = null;

		Manifold mfold = new Manifold();
		while ((line = br.readLine()) != null) {
			mfold.appendLine(line);
		}

		Optional<Long> count = mfold.getTimelineCount();
		System.out.println(count.get());
	}
}
