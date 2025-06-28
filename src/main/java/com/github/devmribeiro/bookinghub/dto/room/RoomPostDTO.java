package com.github.devmribeiro.bookinghub.dto.room;

import com.github.devmribeiro.bookinghub.model.Room;

public class RoomPostDTO {
	private String label;
	private Integer capacity;
	private String type;

	public Room toEntity() {
		Room room = new Room();
		room.setLabel(this.label);
		room.setCapacity(this.capacity);
		room.setType(this.type);
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