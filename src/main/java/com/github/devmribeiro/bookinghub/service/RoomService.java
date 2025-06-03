package com.github.devmribeiro.bookinghub.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}