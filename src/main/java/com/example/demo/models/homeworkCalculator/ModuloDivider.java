package com.example.demo.models.homeworkCalculator;

public class ModuloDivider {
	private double answer;
	
	public ModuloDivider(double first, double second) {
		answer = first % second;
	}
	
	public double calculate() {
		return answer;
	}
}
