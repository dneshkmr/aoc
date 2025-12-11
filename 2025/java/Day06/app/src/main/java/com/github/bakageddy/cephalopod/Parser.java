package com.github.bakageddy.cephalopod;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import com.github.bakageddy.Operator;

public class Parser {

	ArrayList<char[]> grid;

	public Parser() {
		this.grid = new ArrayList<>();
	}

	public void appendLine(String line) {
		grid.add(line.toCharArray());
	}

	public void parseProblem() {
		int grid_len = grid.size();
		char[] operator_line = grid.get(grid_len - 1);
		Deque<Long> nums = new ArrayDeque<>();
		ArrayList<Operator> ops = new ArrayList<>();
		for (int i = 0; i < operator_line.length; i++) {
			String num = new String();
			for (int j = 0; j < grid_len - 1; j++) {
				char c = grid.get(j)[i];
				if (c == ' ') {
					continue;
				}
				num += c;
			}

			long operand = "".equals(num) ? 0 : Long.parseLong(num);
			nums.add(operand);
		}

		for (int i = 0; i < operator_line.length; i++) {
			if (operator_line[i] == '+') {
				ops.add(Operator.Add);
			} else if (operator_line[i] == '*') {
				ops.add(Operator.Mul);
			} else {
				continue;
			}
		}

		long sum = 0;
		for (int i = 0; i < ops.size(); i++) {
			long result;
			Operator op = ops.get(i);
			if (op == Operator.Add) {
				result = 0;
				long temp;
				while (!nums.isEmpty() && (temp = nums.pop()) != 0) {
					result += temp;
				}
			} else {
				result = 1;
				long temp;
				while (!nums.isEmpty() && (temp = nums.pop()) != 0) {
					result *= temp;
				}
			}
			sum += result;
		}

		System.out.println(sum);
	}
}
