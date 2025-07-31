package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequestForm {		//특정 화면에서 요청 들어온 데이터를 담아야하는 용도 DTO
	//화면별로 요청시 검증해야하는 기준이 다른 경우
	
		@NotBlank(message="이거 아이디 필순데?")
		String id;
		//admin/users/add 아이디 이름 비번입력X
		//입력 길이 제한
		String pw;
		@NotBlank(message="이거 이름 필순데?")
		String name;
		String userType; // CUS / ADM
						 // 사용자 계정 구분
						 // Customer / Admin

}
//UserRequestForm 담긴 -> User 객체에 옮겨 담아서 -> userService.saveUser
