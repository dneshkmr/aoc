package com.github.bakageddy;

import java.util.ArrayList;

public class MathHomework {
	ArrayList<Long> operand;
	ArrayList<Operator> operators;

	public MathHomework() {
		this.operand = new ArrayList<>();
		this.operators = new ArrayList<>();
	}

	public void appendOperand(long val) {
		this.operand.add(val);
	}

	public void appendOperator(String operator) {
		if ("+".equals(operator)) {
			this.operators.add(Operator.Add);
		} else if ("*".equals(operator)){
			this.operators.add(Operator.Mul);
		}
	}

	public long[] finishHomework() {
		int row_len = operators.size();
		int col_len = operand.size() / row_len; // NOTE: this must be perfectly divisible
		long[] result = new long[row_len];
		for (int i = 0; i < row_len; i++) {
			Operator op = operators.get(i);
			switch (op) {
				case Add: {
					result[i] = 0;
				}
				break;
				case Mul: {
					result[i] = 1;
				}
				break;
			}
		}

		for (int i = 0; i < operand.size(); i++) {
			Operator op = operators.get(i % row_len);
			switch (op) {
				case Add: {
					result[i % row_len] += operand.get(i);
				}
				break;
				case Mul: {
					result[i % row_len] *= operand.get(i);
				}
			}
		}
		return result;
	}

	public String toString() {
		return new StringBuffer().append(operand).append("\n").append(operators).toString();
	}
}
