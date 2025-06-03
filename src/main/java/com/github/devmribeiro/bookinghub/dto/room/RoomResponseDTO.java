package com.github.devmribeiro.bookinghub.dto.room;

import com.github.devmribeiro.bookinghub.model.Room;

public record RoomResponseDTO (String label, Integer capacity, String type) {
	public RoomResponseDTO(Room room) {
		this(room.getLabel(), room.getCapacity(), room.getType());
	}
}