package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.dto.user.User;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;

@Controller
public class AdminController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;

	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(Room room) {
		
		//값이 잘 넘어왔는가~
		System.out.println(room.toString());
		
		//room 정보 등록
		int result = roomService.saveRoom(room);
		System.out.println(result);
		
		if(result > 0) { //정상적으로 저장 성공
			return "redirect:/admin/rooms";	
		} else { //저장 실패
			return "admin/registerRoom";	
		}		
	}
	
	//관리자가 객실 관리하면서 객실 목록 확인
	@GetMapping("/admin/rooms")
	public String rooms(Model model) {
		
		//rooms 페이지에 보여줄 정보
		// DB 에서 조회
		List<Room> roomList = roomService.findRoomList();
		
		model.addAttribute("roomList", roomList);
		
		return "admin/rooms";		
	}
	
	
	//관리자가 사용자계정관리 -> 사용자 계정을 추가
	@GetMapping("/admin/users/add")
	public String addUser() {
		//화면연결
		return "admin/addUser";
	}
	
	@PostMapping("/admin/users/add")
	public String addUserAction(User user) {
		
		System.out.println(user);
		
		//관리자가 사용자 계정을 추가!!!
		//사용자 계정이니까 userType "CUS" 여야 한다!! 전제조건! 로직!

		/*
		//컨트롤러에서 구분값 처리
		user.setUserType("CUS");
		//저장 처리 진행
		int result = userService.saveUser(user);
		*/
		
		//Customer 사용자 저장용 서비스 메소드 활용
		int result = userService.saveCustomerUser(user);
		
		
		//if(result > 0 ) //정상 저장 처리
		
		return "admin/addUser";
	}
	
}












