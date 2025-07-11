package com.app.controller.study.practice.practice04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.practice.practice03.Beverage;
import com.app.dto.study.practice.practice04.Item;
import com.app.dto.study.practice.practice04.Prac04RequestForm;
import com.app.dto.study.practice.practice04.TransferItem;

@Controller
@RequestMapping("/practice04")
public class Practice04Controller {
//	1. /practice04/request1-x?category=100&product=4000 요청 시, 값들 출력 케이스
//			   Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
//			     1) request 활용 (/request1-1)
//			     2) RequestParam 활용 (/request1-2)
//			     3) Dto 객체 활용 (/request1-3)
//			4) Map 활용 (/request1-4)
	  //1) request 활용 (/request1-1)
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println("/practice04/request1-1");
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "practice/practice04/req";
	}
	//2) RequestParam 활용 (/request1-2)
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam String category,
							 @RequestParam String product) {
		System.out.println("/practice04/request1-2");
		System.out.println(category);
		System.out.println(product);
		
		return "practice/practice04/req";
	}
	//3) Dto 객체 활용 (/request1-3)
	@GetMapping("/request1-3")
	public String request1_3(@ModelAttribute Prac04RequestForm prac04RequestForm) {
		System.out.println("/practice04/request1-4");
		System.out.println(prac04RequestForm.getCategory());
		System.out.println(prac04RequestForm.getProduct());
		
		return "practice/practice04/req";
	}
	//4) Map 활용 (/request1-4)
	@GetMapping("/request1-4")
	public String request1_3(@RequestParam Map<String,String> paramMap) {
		System.out.println("/practice04/request1-4");
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		return "practice/practice04/req";
	}
	//2. /practice04/viewData1-x요청시 화면(view .jsp)에 값 출력
	//* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
	//*전달되는 값은 임의로 작성 "넘어간 값"
	//
	//1) request 활용  ( /viewData1-1)
	//2) Model 활용    /viewData1-2
	//3) ModelAndView 활용   /viewData1-3
	//4) ModelAttribute 객체 활용    /viewData1-4
	
	//1) request 활용  ( /viewData1-1)
	@GetMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		request.setAttribute("response001", "적당히~");
		request.setAttribute("response099", "화면에~");
	
		return "practice/practice04/viewData";
	}
	//2) Model 활용    /viewData1-2
	@GetMapping("/viewData1-2")
	public String viewData1_2(Model model) {
	
		model.addAttribute("response001", "적당히~1-2");
		model.addAttribute("response099", "화면에~1-2");
		
		return "practice/practice04/viewData";
	}
	//3) ModelAndView 활용   /viewData1-3
	@GetMapping("/viewData1-3")
	public ModelAndView viewData1_3() {
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("practice/practice04/viewData");
		mav.addObject("response001", "적당히~1-3");
		mav.addObject("response099", "화면에~1-3");
		
		return mav;
	}
	//4) ModelAttribute 객체 활용    /viewData1-4
	@GetMapping("/viewData1-4")
	public String viewData1_4(Model model) {
		model.addAttribute("response001","적당히~1-4");
		model.addAttribute("response099","화면에~1-4");
		
		TransferItem transferItem = new TransferItem();
		transferItem.setValue001("v001");
		transferItem.setValue099("vvv999");
		
		model.addAttribute("transferItem", transferItem);
		
		return "practice/practice04/viewData";
	}
}

//public class Practice04Controller {
//	@GetMapping("/request1-1")
//	public void request1_1(HttpServletRequest request) {
//		System.out.println("/practice04/request1-1");
//		System.out.println(request.getParameter("category"));
//		System.out.println(request.getParameter("product"));
//		
//		//return "practice/practice03/req";
//	}
////			2) RequestParam 활용 (/request1-2)
//	//practice03/request1-x?item=americano&type=coffee
//	@GetMapping("/request1-2")
//	public void request1_2(@RequestParam String category,
//							 @RequestParam String product) {
//		System.out.println("/practice04/request1-2");
//		System.out.println(category);
//		System.out.println(product);
//		
//		//return "practice/practice03/req";
//	}
//	@GetMapping("/request1-3")
//	public void request1_4(@ModelAttribute Item item) {
//		System.out.println("/practice04/request1-4");
//		System.out.println(item);
//		
//		//return "practice/practice03/req";
//	}
//	@GetMapping("/request1-4")
//	public void request1_3(@RequestParam Map<String,String> paramMap) {
//		System.out.println("/practice04/request1-4");
//		System.out.println(paramMap.get("category"));
//		System.out.println(paramMap.get("product"));
//		
//		//return "practice/practice03/req";
//	}
//	
//	@GetMapping("/viewData1-1")
//	public String viewData1_1(HttpServletRequest request) {
//		//System.out.println("/practice04/request1-1");
//		request.setAttribute("category", 1000);
//		request.setAttribute("product", 40000);
////		System.out.println(request.getParameter("category"));
////		System.out.println(request.getParameter("product"));
//		
//		return "practice/practice04/view";
//	}
//	@GetMapping("/viewData1-2")
//	public String viewData1_2(Model model) {
//		//System.out.println("/practice03/viewData1-2");
//		model.addAttribute("category", "후라이드치킨");
//		model.addAttribute("product", "치킨");
//		
//		return "practice/practice04/view";
//	}
//	@GetMapping("/viewData1-3")
//	public ModelAndView viewData1_3() {
//		//System.out.println("/practice03/viewData1-3");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("practice/practice04/view");
//		mav.addObject("category", "국밥");
//		mav.addObject("product", "순대국밥");
//		
//		return mav;
//	}
//	@GetMapping("/viewData1-4")
//	public String viewData1_4(@ModelAttribute Item item) {
//		//System.out.println("/practice04/request1-4");
//		//System.out.println(item);
//		item.setCategory("햄버거");
//		item.setProduct("빅맥");
//		return "practice/practice04/view";
//	}
//}
