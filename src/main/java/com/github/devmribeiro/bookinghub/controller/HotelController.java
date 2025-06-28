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
import com.github.devmribeiro.bookinghub.model.Hotel;
import com.github.devmribeiro.bookinghub.model.Room;
import com.github.devmribeiro.bookinghub.service.RoomService;
import com.github.devmribeiro.bookinghub.util.ApiResponse;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {

	private final RoomService roomService;

	public HotelController(RoomService roomService) {
		this.roomService = roomService;
	}

	@ResponseBody
	@GetMapping("/{hotelId}/rooms/{roomId}")
	public ResponseEntity<RoomResponseDTO> listById(
			@PathVariable(value = "hotelId") Integer hotelId,
			@PathVariable("roomId") Integer roomId) {

		return ResponseEntity.ok(new RoomResponseDTO(roomService.listById(roomId, hotelId)));
	}

	@ResponseBody
	@GetMapping("/{hotelId}/rooms")
	public ResponseEntity<List<RoomResponseDTO>> list(
			@PathVariable(value = "hotelId") Integer hotelId,
			@RequestParam(value = "capacity") Integer capacity,
			@RequestParam(value = "type") String type) {

		List<Room> result = roomService.list(capacity, type, hotelId);

	    if (result == null || result.isEmpty())
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	    List<RoomResponseDTO> response = result.stream()
	            .map(room -> new RoomResponseDTO(room))
	            .collect(Collectors.toList());

	    return ResponseEntity.ok(response);
	}

	@PostMapping("/{hotelId}/rooms/")
	public ResponseEntity<ApiResponse> create(
			@PathVariable("hotelId") Integer hotelId,
			@RequestBody RoomPostDTO dto) {

		Room room = dto.toEntity();
		Hotel hotel = new Hotel();
		hotel.setHotelId(hotelId);
		room.setHotel(hotel);
		
	    Room createdRoom = roomService.create(room);
	    URI location = URI.create("/hotels/" + hotelId + "/rooms/" + createdRoom.getRoomId());
	    return 
    		ResponseEntity
    		.created(location)
    		.body(new ApiResponse("Successfully Added Room", createdRoom.getRoomId()));
	}

	@PutMapping("/{hotelId}/rooms/{roomId}")
	public ResponseEntity<RoomResponseDTO> edit(
			@PathVariable(value = "hotelId") Integer hotelId,
			@PathVariable Integer roomId,
			@RequestBody RoomPostDTO dto) {

		return ResponseEntity.ok(new RoomResponseDTO(roomService.edit(roomId, dto.toEntity(), hotelId)));
	}
	
	@DeleteMapping("/{hotelId}/rooms/{roomId}")
	public ResponseEntity<ApiResponse> delete(
			@PathVariable(value = "hotelId") Integer hotelId,
			@PathVariable Integer roomId) {

		roomService.delete(roomId, hotelId);
		return ResponseEntity.ok(new ApiResponse("Successfully Deleted Room", roomId));
	}
}