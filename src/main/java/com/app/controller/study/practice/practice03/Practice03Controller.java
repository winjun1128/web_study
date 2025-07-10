package com.app.controller.study.practice.practice03;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.controller.study.practice.practice03.DTO.Drink;
import com.app.dto.study.Product;
import com.app.dto.study.ProductRequestForm;
import com.app.dto.study.practice.practice03.Beverage;
import com.app.dto.study.practice.practice03.DrinkItem;

@Controller
@RequestMapping("/practice03")
public class Practice03Controller {
//	1. /practice03/request1-x?item=americano&type=coffee 요청 시, 값들 출력 케이스
//			Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
//			1) request 활용 (/request1-1)
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println("/practice03/request1-1");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		
		return "practice/practice03/req";
	}
//			2) RequestParam 활용 (/request1-2)
	//practice03/request1-x?item=americano&type=coffee
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam(required=false) String item,
							 @RequestParam(required=false) String type) {
		System.out.println("/practice03/request1-2");
		System.out.println(item);
		System.out.println(type);
		
		return "practice/practice03/req";
	}
//			3) RequestParam Map 활용 (/request1-3)
	//practice03/request1-x?item=americano&type=coffee
	@GetMapping("/request1-3")
	public String request1_3(@RequestParam Map<String,String> paramMap) {
		System.out.println("/practice03/request1-3");
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		
		return "practice/practice03/req";
	}
//			4) 자바 Dto 객체 활용 (/request1-4)
	//practice03/request1-x?item=americano&type=coffee
	@GetMapping("/request1-4")
	public String request1_4(@ModelAttribute Beverage beverage) {
		System.out.println("/practice03/request1-4");
		System.out.println(beverage);
		
		return "practice/practice03/req";
	}
	
//	2. /practice03/viewData1-x 요청시 화면에 값 출력
//
//	1) request 활용 /viewData1-1
	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		System.out.println("/practice03/viewData1-1");
		request.setAttribute("name", "싸이버거");
		request.setAttribute("type", "햄버거");
		
		return "practice/practice03/viewData";
	}
//	2) Model 활용 /viewData1-2
	@GetMapping("/viewData1-2")
	public String viewData1_2(Model model) {
		System.out.println("/practice03/viewData1-2");
		model.addAttribute("name", "후라이드치킨");
		model.addAttribute("type", "치킨");
		
		return "practice/practice03/viewData";
	}
//	3) ModelAndView 활용 /viewData1-3
	@GetMapping("/viewData1-3")
	public ModelAndView viewData1_3() {
		System.out.println("/practice03/viewData1-3");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("practice/practice03/viewData");
		mav.addObject("name", "순대국박");
		mav.addObject("type", "국밥");
		
		return mav;
	}
//	4) Model에 객체 단위로 전달 활용 /viewData1-4
	@GetMapping("/viewData1-4")
	public String viewData1_4(Model model) {
		System.out.println("/practice03/viewData1-4");
		//model.addAttribute("name", "후라이드치킨");
		//model.addAttribute("type", "치킨");
		
		DrinkItem drinkItem = new DrinkItem();
		drinkItem.setName("콜라");
		drinkItem.setType("탄산음료");
		
		model.addAttribute("drinkItem", drinkItem);
		
		return "practice/practice03/viewData";
	}
//	* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
//	*전달되는 값은 임의로 작성 "넘어간 값"
//	단일 1), 2), 3)
//	${name}
//	${type}
//
//	* 화면에 객체를 표시할때 사용하는 코드
//	객체 4)
//	${drinkItem.name}
//	${drinkItem.type}
}

//package com.app.controller.study.practice.practice03;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.http.HttpRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.app.controller.study.practice.practice03.DTO.Drink;
//import com.app.dto.study.Product;
//import com.app.dto.study.ProductRequestForm;
//
//@Controller
//@RequestMapping("/practice03")
//public class Practice03Controller {
//	@GetMapping("/request1-1")
//	public String request1_1(HttpServletRequest request) {
//		System.out.println(request.getParameter("item"));
//		System.out.println(request.getParameter("type"));
//		return "practice/practice03/request";
//	}
//	@RequestMapping("/request1-2")
//	public String req3(@RequestParam String item,@RequestParam String type) {
//		System.out.println(item);
//		System.out.println(type);
//		return "practice/practice03/request";
//	}
//	@RequestMapping("/request1-3")
//	public String param7(@RequestParam Map<String,String> paramMap) {
//						//paramMap 안에 요청 들어온 파라미터 값들이 Key:Value 형태로 저장되어 전달됨
//		System.out.println(paramMap.get("item"));
//		System.out.println(paramMap.get("type"));
//		
//		return "practice/practice03/request";
//	}
//	@GetMapping("/request1-4")		//	POST 쓰기/데이터전달	실제 데이터를 전달 받아서 로직 처리
//	public String param8Action(@ModelAttribute Drink drink) {
//
//		System.out.println(drink);
//	
//		
//		//productRequestForm -> product
//		//					 -> otherDTO
//		
//		return "practice/practice03/request";
//		
//	}
//	@GetMapping("/viewData1-1")
//	public String viewData1_1(HttpServletRequest request) {
//		request.setAttribute("item", "americano");
//		request.setAttribute("type", "coffee");
//		return "practice/practice03/request";
//	}
//	@GetMapping("/viewData1-2")
//	public String viewData1_2(Model model) {
//		
//		model.addAttribute("item","americano");
//		model.addAttribute("type","coffee");
//		
//		return "practice/practice03/request";
//	}
//	@GetMapping("/viewData1-3")
//	public ModelAndView viewData1_3(ModelAndView mav) {
//		
//		mav.setViewName("practice/practice03/request");
//		mav.addObject("item","americano");
//		mav.addObject("type","coffee");
//		
//		return mav;
//	}
//	
//	@GetMapping("/viewData1-4")
//	public String viewData5(Model model) {
//		
//		
//		Drink drink = new Drink();
//		drink.setItem("americano");
//		drink.setType("coffee");
//	
//		model.addAttribute("drinkItem",drink);
//		
//		return "practice/practice03/request";
//	}
//}
