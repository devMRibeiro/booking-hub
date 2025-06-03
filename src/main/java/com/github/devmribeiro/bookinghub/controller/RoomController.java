package com.github.devmribeiro.bookinghub.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.bookinghub.dto.room.RoomResponseDTO;
import com.github.devmribeiro.bookinghub.model.Room;
import com.github.devmribeiro.bookinghub.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	private final RoomService service;

	public RoomController(RoomService service) {
		this.service = service;
	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<List<RoomResponseDTO>> list(
			@RequestParam(value = "capacity", required = false) Integer capacity,
			@RequestParam(value = "type", required = false) String type) {

		List<Room> result = service.list(capacity, type);
		
	    if (result == null || result.isEmpty())
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	    List<RoomResponseDTO> response = result.stream()
	            .map(RoomResponseDTO::new)
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(response);
	}
}