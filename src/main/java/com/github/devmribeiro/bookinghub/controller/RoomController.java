package com.github.devmribeiro.bookinghub.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.bookinghub.dto.room.RoomPostDTO;
import com.github.devmribeiro.bookinghub.dto.room.RoomResponseDTO;
import com.github.devmribeiro.bookinghub.model.Room;
import com.github.devmribeiro.bookinghub.service.RoomService;
import com.github.devmribeiro.bookinghub.util.ApiResponse;

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
	public ResponseEntity<ApiResponse> create(@RequestBody RoomPostDTO dto) {
	    Room createdRoom = service.create(dto.toEntity(dto));
	    URI location = URI.create("/room/" + createdRoom.getRoomId());
	    return 
    		ResponseEntity
    		.created(location)
    		.body(new ApiResponse("Successfully Added Room", createdRoom.getRoomId()));
	}

	@PutMapping("/edit/{roomId}")
	public ResponseEntity<RoomResponseDTO> edit(@PathVariable Integer roomId, @RequestBody RoomPostDTO dto) {
		return ResponseEntity.ok(new RoomResponseDTO(service.edit(roomId, dto.toEntity(dto))));
	}
	
	@DeleteMapping("delete/{roomId}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer roomId) {
		service.delete(roomId);
		return ResponseEntity.ok(new ApiResponse("Successfully Deleted Room", roomId));
	}
}