package com.github.bakageddy;

public enum Operator {
	Add,
	Mul;

	public static boolean isOperator(String operator) {
		return "+".equals(operator) || "*".equals(operator);
	}

	public static boolean isOperator(char operator) {
		return '+' == operator || '*' == operator;
	}
}
