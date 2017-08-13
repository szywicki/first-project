package com.example.demo.models.homeworkCalculator;

public class Divider {
	
	private double quotient;

	public Divider(double first, double second) {
		quotient = first / second;
	}
	
	public double calculate() {
		return quotient;
	}
}
