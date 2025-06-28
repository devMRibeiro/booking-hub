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

	public Room listById(Integer roomId, Integer hotelId) {
		Room room = repository.findByRoomId(roomId, hotelId);

		if (room == null)
			throw new ResourceNotFoundException("Room available with roomId not found");

		return room;
	}

	public List<Room> list(Integer capacity, String type, Integer hotelId) {
		if (capacity != null && type != null && !type.isBlank())
			return repository.findByTypeAndCapacity(type, capacity, hotelId);

		if (capacity != null)
			return repository.findByCapacity(capacity, hotelId);

		if (type != null && !type.isBlank())
			return repository.findByType(type, hotelId);

		return repository.findAll(hotelId); 
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
	
	public Room edit(Integer roomId, Room room, Integer hotelId) {
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

		Room originalRoom = repository.findByRoomId(roomId, hotelId);

		if (originalRoom == null)
			throw new ResourceNotFoundException("Room with ID " + roomId + " not found");

		originalRoom.setLabel(room.getLabel());
		originalRoom.setType(room.getType());
		originalRoom.setCapacity(room.getCapacity());

		return repository.save(originalRoom);
	}

	public void delete(Integer roomId, Integer hotelId) {
		if (roomId == null || roomId < 1)
			throw new InvalidInputException("Invalid Room ID");

		if (repository.findByRoomId(roomId, hotelId) == null)
			throw new ResourceNotFoundException("Room with ID " + roomId + " not found");

		repository.deleteById(roomId);
	}
}