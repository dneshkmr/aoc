package com.github.bakageddy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.bakageddy.cephalopod.Parser;

public class Part2 {
	public static void run(String[] args) throws Exception {
		InputStream in = Part2.class.getClassLoader().getResourceAsStream("input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		Parser parser = new Parser();
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			parser.appendLine(line);
		}

		parser.parseProblem();
	}
}
