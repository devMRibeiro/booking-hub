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

	public List<Room> list(String type) {
		if (type == null || type.isBlank())
			return repository.findAll();
		return repository.findByType(type); 
	}
}