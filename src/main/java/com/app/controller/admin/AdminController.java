package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//roomId 식별자로 구분해서, 하나의 객실에 대한 상세정보 페이지
	@GetMapping("/admin/room/{roomId}")
	public String room(@PathVariable String roomId, Model model) {
		
		Room room = roomService.findRoomByRoomId(Integer.parseInt(roomId));
		model.addAttribute("room", room);
		
		return "admin/room";
	}
	
	
	// /admin/removeRoom?roomId=2
	@GetMapping("/admin/removeRoom")
	public String removeRoom(HttpServletRequest request) {
		
		String roomId = request.getParameter("roomId");
		
		int result = roomService.removeRoom(Integer.parseInt(roomId));
		
		//if(result > 0) 
		
		return "redirect:/admin/rooms";	
	}
	
	
	//객실 정보 수정
	@GetMapping("/admin/modifyRoom")   // /admin/modifyRoom?roomId=xxx
	public String modifyRoom(HttpServletRequest request) {
		
		String roomId = request.getParameter("roomId");
		//PK roomId 에 해당하는 정보를 조회 해서
		Room room = roomService.findRoomByRoomId( Integer.parseInt(roomId));
		System.out.println("기존에 가지고 있는 정보 조회한 값");
		System.out.println(room);
		
		//화면에 기본값으로 보여주고! -> 사용자가 수정해라 ~
		request.setAttribute("room", room);
		
		return "admin/modifyRoom";
	}
	
	@PostMapping("/admin/modifyRoom")
	public String modifyRoomAction(Room room) {
		
		System.out.println("수정하려고 하는 객체 값");
		System.out.println(room);
		// room 객체에 데이터가 저장되어 있는 상태
		// 기존값, 변경하겠다고 수정한 값
		int result = roomService.modifyRoom(room);
		
		if(result > 0) { //성공    목록~ or 호실 상세 페이지
			//return "redirect:/admin/rooms";  //목록
			return "redirect:/admin/room/" + room.getRoomId();  //해당 호실 상세 페이지
		} else { //실패  // 다시 수정하는 페이지로 이동
			return "redirect:/admin/modifyRoom?roomId=" + room.getRoomId();	
		}
		
		
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
		
		
		if(result > 0 ) { //정상 저장 처리
			return "redirect:/admin/users";
		} else {
			return "admin/addUser";	
		}
	}
	
	@GetMapping("/admin/users")
	public String users(Model model) {
		List<User> userList = userService.findUserList();
		
		model.addAttribute("userList", userList);
		
		return "admin/users";
	}
	
	@GetMapping("/admin/user/{id}")
	public String user(@PathVariable String id, Model model) {
		
		User user = userService.findUserById(id);
		model.addAttribute("user" , user);		
		
		return "admin/user";
	}
	
	@GetMapping("/admin/modifyUser/{id}")
	public String modifyUser(@PathVariable String id, Model model) {
		
		//수정 페이지 (기존 값 배치)
		User user = userService.findUserById(id);
		model.addAttribute("user" , user);		
		
		return "admin/modifyUser";
	}
	
	@PostMapping("/admin/modifyUser")
	public String modifyUserAction(User user) {
		
		System.out.println("modifyUser 수정하려고 넘어온 User 객체");
		System.out.println(user);
		
		int result = userService.modifyUser(user);
		
		if(result > 0) { //성공 : 사용자 상세페이지
			return "redirect:/admin/user/" + user.getId();
		} else {  // 실패 : 다시 수정하는 페이지
			return "redirect:/admin/modifyUser/" + user.getId();
		}
		
		
		
	}
	
	
}












