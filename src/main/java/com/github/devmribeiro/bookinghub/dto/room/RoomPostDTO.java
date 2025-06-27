package com.github.devmribeiro.bookinghub.dto.room;

import com.github.devmribeiro.bookinghub.model.Room;

public class RoomPostDTO {
	private String label;
	private Integer capacity;
	private String type;

	public Room toEntity(RoomPostDTO dto) {
		Room room = new Room();
		room.setLabel(dto.getLabel());
		room.setCapacity(dto.getCapacity());
		room.setType(dto.getType());
		return room;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}