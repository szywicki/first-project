package com.example.demo.models.homeworkCalculator;

public class Exponential {
	private double exponent;
	
	public Exponential(double first, double second) {
		exponent = first * second;
	}
	
	public double calculate() {
		return exponent; 
	}
}
