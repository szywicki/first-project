package com.example.demo.models.homeworkCalculator;

public class Subtracter {
	// int secret1;
	// double secret2;
	private double difference;
	
	public Subtracter (double first, double second) {
	//	secret1 = first;
	//	secret2 = second;
		difference = first - second; 
	}
	
	public double calculate() {
	//	return secret1 - secret2;
		return difference;
	}
}
