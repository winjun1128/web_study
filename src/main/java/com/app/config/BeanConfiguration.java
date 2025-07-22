package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.dao.room.RoomDAO;
import com.app.dao.room.impl.RoomDAOImpl;
import com.app.service.room.RoomService;
import com.app.service.room.impl.RoomServiceImpl;


//@Configuration
public class BeanConfiguration {

	//스프링에 적용되는 설정들이 들어있는 클래스 
	
	//RoomDAO roomDAO = new RoomDAOImpl();
	
	@Bean
	public RoomDAO roomDAO() {
		return new RoomDAOImpl();
	}
	
	@Bean
	public RoomService roomService(RoomDAO roomDAO) {
		
		/*
		//생성자를 통한 의존성 주입
		RoomServiceImpl roomService = new RoomServiceImpl(roomDAO);
		*/
		
		/*
		//setter 메소드를 통한 의존성 주입
		RoomServiceImpl roomService = new RoomServiceImpl();
		roomService.setRoomDAO(roomDAO);
		*/
		
		//return roomService;
		
		return null;
	}
}
