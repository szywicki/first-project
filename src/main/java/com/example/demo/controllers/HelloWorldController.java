package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message")
	public ModelAndView makeThingsLoud(@RequestParam(required=false, defaultValue="«YELL IN THE LIBRARY!»") String message) {
		Yeller loudMaker = new Yeller(message);
		String yellerResult = loudMaker.louder();
		
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", yellerResult);
		return mv;
	}
	
	@GetMapping("whisper")
	public ModelAndView makeThingsQuiet(@RequestParam(required=false, defaultValue="«shhhhhh»") String message) {
		Whisperer quietMaker = new Whisperer(message);
		String whisperResult = quietMaker.quiet();
		
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		mv.addObject("message", whisperResult);
		return mv;
	}

		
	//@GetMapping("message") // URL to which the form submits
	//public ModelAndView messageParam(@RequestParam(required=false, defaultValue="«silence»") String message) {
		//ModelAndView mv = new ModelAndView("helloworld/message");
	//	mv.addObject("title", title);
	//	mv.addObject("message", message);
	//	return mv;
	//}
	 
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		model.addAttribute("sum", first + second);
		return "helloworld/sum-result";
	}
	
}
