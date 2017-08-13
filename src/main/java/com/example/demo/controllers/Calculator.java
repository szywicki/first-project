package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;

@Controller
@RequestMapping("/calculator")

public class Calculator {
	@PostMapping("")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "Calculator/calc-result";
	}
	
	@GetMapping("")
	public String adder(Model model) {
		model.addAttribute("sum", "Put in your numbers and press a button!!");
		return "Calculator/calc-result";
	}
}

