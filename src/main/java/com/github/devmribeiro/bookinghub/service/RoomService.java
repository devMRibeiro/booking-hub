package com.github.devmribeiro.bookinghub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.devmribeiro.bookinghub.exception.InvalidInputException;
import com.github.devmribeiro.bookinghub.model.Room;
import com.github.devmribeiro.bookinghub.repository.RoomRepository;

@Service
public class RoomService {

	private final RoomRepository repository;

	public RoomService(RoomRepository repository) {
		this.repository = repository;
	}

	public List<Room> list(Integer capacity, String type) {
		if (capacity != null && type != null || !type.isBlank())
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
			throw new InvalidInputException("Label field connot be empty");

		if (room.getType() == null || room.getType().isBlank())
			throw new InvalidInputException("Type field connot be empty");

		if (room.getCapacity() == null || room.getCapacity() < 1)
			throw new InvalidInputException("Capacity field connot be empty or less than 1");

		return repository.save(room);
	}
}