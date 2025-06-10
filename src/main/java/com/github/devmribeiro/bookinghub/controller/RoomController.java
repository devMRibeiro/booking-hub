package com.github.devmribeiro.bookinghub.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.bookinghub.dto.room.RoomCreateDTO;
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

	@GetMapping("/{roomId}")
	public @ResponseBody ResponseEntity<RoomResponseDTO> listById(@RequestParam("roomId") Integer roomId) {
		return ResponseEntity.ok(new RoomResponseDTO(service.listById(roomId)));
	}

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<List<RoomResponseDTO>> list(
			@RequestParam(value = "capacity", required = false) Integer capacity,
			@RequestParam(value = "type", required = false) String type) {

		List<Room> result = service.list(capacity, type);

	    if (result == null || result.isEmpty())
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	    List<RoomResponseDTO> response = result.stream()
	            .map(room -> new RoomResponseDTO(room))
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(response);
	}

	@PostMapping("/create")
	public ResponseEntity<RoomResponseDTO> create(@RequestBody RoomCreateDTO dto) {
	    Room createdRoom = service.create(dto.toEntity(dto));
	    RoomResponseDTO responseDTO = new RoomResponseDTO(createdRoom);
	    URI location = URI.create("/room/" + createdRoom.getRoomId());
	    return ResponseEntity
	            .created(location)
	            .body(responseDTO);
	}
}