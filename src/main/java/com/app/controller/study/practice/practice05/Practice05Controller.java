package com.app.controller.study.practice.practice05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice05")
public class Practice05Controller {

//localhost:8080/practice05/pathA -> 퀴즈 페이지 A 상품정보 표시
//
//localhost:8080/practice05/pathB -> 퀴즈 페이지 B 상품정보 표시
//
//localhost:8080/practice05/pathCommon/A -> 퀴즈 페이지 A 상품정보 표시
//
//localhost:8080/practice05/pathCommon/B -> 퀴즈 페이지 B 상품정보 표시
	
	
	//localhost:8080/practice05/pathA -> 퀴즈 페이지 A 상품정보 표시
	//1) 경로별 각자 개별 페이지를 사용하는 케이스
//	@GetMapping("/pathA")
//	public String PathA() {
//		return "practice/practice05/pathA";
//	}
//	@GetMapping("/pathB")
//	public String PathB() {
//		return "practice/practice05/pathB";
//	}
//	@GetMapping("/pathCommon/A")
//	public String pathCommonA() {
//	
//		return "practice/practice05/pathCommon/A";
//	}
//	@GetMapping("/pathCommon/B")
//	public String PathCommonB() {
//	
//		return "practice/practice05/pathCommon/B";
//	}
	//2) (상품기준) A정보, B정보 2개의 페이지를 기준으로 사용하는 케이스
//	@GetMapping("/pathA")
//	public String PathA() {
//		return "practice/practice05/pathA";
//	}
//	@GetMapping("/pathB")
//	public String PathB() {
//		return "practice/practice05/pathB";
//	}
//	@GetMapping("/pathCommon/A")
//	public String pathCommonA() {
//	
//		return "practice/practice05/pathA";
//	}
//	@GetMapping("/pathCommon/B")
//	public String PathCommonB() {
//	
//		return "practice/practice05/pathB";
//	}
	//2)
	@GetMapping(value = {"/pathA","/pathCommon/A"})
	public String PathA() {
		return "practice/practice05/pathA";
	}
	@GetMapping({"/pathB","/pathCommon/B"})
	public String PathB() {
		return "practice/practice05/pathB";
	}
	
	//3) pathA, pathB는 각자 페이지, pathCommon 공통 페이지에 동적 데이터 전달
//	@GetMapping("/pathA")
//	public String PathA() {
//		return "practice/practice05/pathA";
//	}
//	@GetMapping("/pathB")
//	public String PathB() {
//		return "practice/practice05/pathB";
//	}
//	@GetMapping("/pathCommon/A")
//	public String pathCommonA(Model model) {
//		
//		model.addAttribute("productName","A");
//	
//		return "practice/practice05/pathCommon/common";
//	}
//	@GetMapping("/pathCommon/B")
//	public String PathCommonB(Model model) {
//		
//		model.addAttribute("productName","B");
//	
//		return "practice/practice05/pathCommon/common";
//	}
	
	// + pathCommon/pathVariable 형태로 사용
//	@GetMapping("/pathCommon/{productName}")
//	public String pathCommonA(@PathVariable String productName,Model model) {
//		
//		//경로에 있는 값 productName -> DB 조회
//		//올바른 값인지 검증
//		//그 정보에 맞는 데이터 획득 후 -> 화면 전달
//		model.addAttribute("productName",productName);
//	
//		return "practice/practice05/pathCommon/common";
//	}
	//4) 모든 경로가 동일한 공통 페이지 사용 케이스
	@GetMapping("/pathA")
	public String PathA(Model model) {
		model.addAttribute("productName", "A");
		return "practice/practice05/pathCommon/common";
	}
	@GetMapping("/pathB")
	public String PathB(Model model) {
		model.addAttribute("productName", "B");
		return "practice/practice05/pathCommon/common";
	}
	@GetMapping("/pathCommon/A")
	public String pathCommonA(Model model) {
		model.addAttribute("productName", "A");
		return "practice/practice05/pathCommon/common";
	}
	@GetMapping("/pathCommon/B")
	public String PathCommonB(Model model) {
		model.addAttribute("productName", "B");
		return "practice/practice05/pathCommon/common";
	}
}
//public class Practice05Controller {
//	@GetMapping("/pathA")
//	public String viewPathA(HttpServletRequest request) {
//		System.out.println("/practice05/pathA");
//		request.setAttribute("A", "A 상품 정보");
//		
//		return "practice/practice05/viewData";
//	}
//	@GetMapping("/pathB")
//	public String viewPathB(HttpServletRequest request) {
//		System.out.println("/practice05/pathB");
//		request.setAttribute("B", "B 상품 정보");
//		
//		return "practice/practice05/viewData";
//	}
//	@GetMapping("/pathCommon/A")
//	public String viewPathCommon_A(HttpServletRequest request) {
//		System.out.println("/practice05/pathCommon/A");
//		request.setAttribute("A", "A 상품 정보");
//		
//		return "practice/practice05/viewData";
//	}
//	@GetMapping("/pathCommon/B")
//	public String viewPathCommon_B(HttpServletRequest request) {
//		System.out.println("/practice05/pathCommon/B");
//		request.setAttribute("B", "B 상품 정보");
//		
//		return "practice/practice05/viewData";
//	}
//}
