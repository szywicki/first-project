package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.homeworkCalculator.Adder;
import com.example.demo.models.homeworkCalculator.Divider;
import com.example.demo.models.homeworkCalculator.ModuloDivider;
import com.example.demo.models.homeworkCalculator.Multiplier;
import com.example.demo.models.homeworkCalculator.Subtracter;

@Controller
@RequestMapping("/calculator")

public class Calculator {
	@PostMapping("")
	public String calculateTwoNumbers
	(@RequestParam(name="left") double first, 
			@RequestParam(name="right") double second, 
			@RequestParam(name="calculateChoice") String buttonChoice, 
			Model theThingIPutDataIntoForTheView)
			 {
		if (buttonChoice.equals("add")) {
			Adder additionProblem = new Adder (first, second);
			double adder = additionProblem.calculate();
			theThingIPutDataIntoForTheView.addAttribute("result", adder);
		}
		
		else if (buttonChoice.equals("substract")) {
			Subtracter subtractionProblem = new Subtracter (first, second);
			double subtracter = subtractionProblem.calculate();
			theThingIPutDataIntoForTheView.addAttribute("result", subtracter);
		}
		
		else if (buttonChoice.equals("multiply")) {
			Multiplier multiplicationProblem = new Multiplier (first, second);
			double multiplier = multiplicationProblem.calculate();
			theThingIPutDataIntoForTheView.addAttribute("result", multiplier);
		}
		
		else if (buttonChoice.equals("divide")) {
			Divider divisionProblem = new Divider (first, second);
			double divider = divisionProblem.calculate();
			theThingIPutDataIntoForTheView.addAttribute("result", divider);
		}
		
		else if (buttonChoice.equals("modulo")) {
			ModuloDivider moduloProblem = new ModuloDivider (first, second);
			double modulo = moduloProblem.calculate();
			theThingIPutDataIntoForTheView.addAttribute("result", modulo);
		}
		return "Calculator/calc-result";
		
	}
	
//	@GetMapping("adder")
//	public ModelAndView adder(@RequestParam(name="left") double first) @RequestParam(name="right")double second {
//		Adder adder = new Adder(first, second);
//		double result = adder.calculate()
//				
//		ModelAndView mv = new ModelAndView ("sum", "Put in your numbers and press a button!");
//		mv.addObject(attributeValue)
//		mv.addObject("adder", result)
//		return mv;
//	}
	@GetMapping("")
	public String showTheCalc() {
		return "Calculator/calc-home";
	}
}

