package com.github.bakageddy.cephalopod;

import com.github.bakageddy.Operator;
import java.util.ArrayList;

public class Problem {
	public ArrayList<Long> operands;
	public Operator operator;

	public Problem() {
		this.operands = new ArrayList<>();
	}

	public String toString() {
		return new StringBuilder().append(operands).append(' ').append(this.operator == Operator.Add ? '+' : '*').toString();
	}
}
