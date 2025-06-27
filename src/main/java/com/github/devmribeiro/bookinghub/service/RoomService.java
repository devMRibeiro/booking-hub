package com.github.devmribeiro.bookinghub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.devmribeiro.bookinghub.exception.InvalidInputException;
import com.github.devmribeiro.bookinghub.exception.ResourceNotFoundException;
import com.github.devmribeiro.bookinghub.model.Room;
import com.github.devmribeiro.bookinghub.repository.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository repository;

	public RoomService(RoomRepository repository) {
		this.repository = repository;
	}

	public Room listById(Integer roomId) {
		Room room = repository.findByRoomId(roomId);

		if (room == null)
			throw new ResourceNotFoundException("Room available with roomId not found");

		return room;
	}

	public List<Room> list(Integer capacity, String type) {
		if (capacity != null && type != null && !type.isBlank())
			return repository.findByTypeAndCapacity(type, capacity);

		if (capacity != null)
			return repository.findByCapacity(capacity);

		if (type != null && !type.isBlank())
			return repository.findByType(type);

		return repository.findAll(); 
	}

	public Room create(Room room) {
		if (room == null)
			throw new InvalidInputException("Fill in the fields correctly");

		if (room.getLabel() == null || room.getLabel().isBlank())
			throw new InvalidInputException("Label field cannot be empty");

		if (room.getType() == null || room.getType().isBlank())
			throw new InvalidInputException("Type field cannot be empty");

		if (room.getCapacity() == null || room.getCapacity() < 1)
			throw new InvalidInputException("Capacity field cannot be empty or less than 1");

		return repository.save(room);
	}
	
	public Room edit(Integer roomId, Room room) {
		if (roomId == null || roomId < 1)
			throw new InvalidInputException("Invalid Room ID");

		if (room == null)
			throw new InvalidInputException("Fill in the fields correctly");

		if (room.getLabel() == null || room.getLabel().isBlank())
			throw new InvalidInputException("Label field cannot be empty");

		if (room.getType() == null || room.getType().isBlank())
			throw new InvalidInputException("Type field cannot be empty");

		if (room.getCapacity() == null || room.getCapacity() < 1)
			throw new InvalidInputException("Capacity field cannot be empty or less than 1");

		Room originalRoom = repository.findByRoomId(roomId);

		if (originalRoom == null)
			throw new ResourceNotFoundException("Room with ID " + roomId + " not found");

		originalRoom.setLabel(room.getLabel());
		originalRoom.setType(room.getType());
		originalRoom.setCapacity(room.getCapacity());

		return repository.save(originalRoom);
	}
}