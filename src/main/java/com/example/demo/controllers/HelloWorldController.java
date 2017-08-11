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
	
	@GetMapping("say-something")
	public String makeAChoice (
			String message,
			String speechChoice,
			Model theThingIPutDataIntoForTheView
			) {
	// if speech choice is yell
	if (speechChoice.equals("yell")) {
	// then make message loud
		Yeller aVariableThatHoldsAYellerObject = new Yeller(message);
		String loud = aVariableThatHoldsAYellerObject.louder();
		theThingIPutDataIntoForTheView.addAttribute("output", loud);
	} else {
		// otherwise
		// make message quiet
		Whisperer someQuietThing = new Whisperer (message);
		String quiet = someQuietThing.quiet();
		theThingIPutDataIntoForTheView.addAttribute("output", quiet);
	}
	return "helloworld/mixed-messages";
	}
}
