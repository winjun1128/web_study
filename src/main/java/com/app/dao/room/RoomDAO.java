package com.app.dao.room;

import java.util.List;

import com.app.dto.room.Room;

public interface RoomDAO {

	List<Room> findRoomList();
	
	int saveRoom(Room room);
	
	Room findRoomByRoomId(int roomId);
	
	int removeRoom(int roomId);
}
