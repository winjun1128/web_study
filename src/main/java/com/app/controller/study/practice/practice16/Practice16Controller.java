package com.app.controller.study.practice.practice16;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.CommonCode;
import com.app.dto.user.User;

@Controller
public class Practice16Controller {
	
	@GetMapping("/practice16/quiz1")
	public String quiz1() {
		return "practice/practice16/quiz1";
	}
	
	@ResponseBody
	@GetMapping("/practice16/quiz2")
	public String quiz2() {
		return "return text quiz2";
	}
	
	@ResponseBody
	@GetMapping("/practice16/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		//@ResponseBody or @RestController
		//REST API 통신으로 response body 에 텍스트로 반환하는 상황!
		//객체 리턴! -> 객체를 JSON 포맷으로 변환 -> return
		//**조건 : jackson 라이브러리 존재!! (의존성 추가)
		return user;
	}
}	
