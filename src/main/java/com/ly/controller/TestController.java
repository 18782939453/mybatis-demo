package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@GetMapping("/hello")
	@ResponseBody
	public String helloWorld(){
		return "hello23";
	}
}
