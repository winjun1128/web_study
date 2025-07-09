package com.app.controller.study.practice.practice01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice01")
public class Practice01Controller {
	@RequestMapping("/main")
	public String main() {
		return "practice/practice01/main";
	}
	
//	@RequestMapping(value = "/product/mouse",method=RequestMethod.GET)
//	public String product_mouse() {
//		return "/practice01/product/mouse";
//	}
	@RequestMapping("/product/mouse")
	public String product_mouse() {
		return "practice/practice01/product/mouse";
	}
	
//	@GetMapping("/product/keyboard")
//	public String product_keyboard() {
//		return "/practice01/product/keyboard";
//	}
	@RequestMapping("/product/keyboard")
	public String product_keyboard() {
		return "practice/practice01/product/keyboard";
	}

}
