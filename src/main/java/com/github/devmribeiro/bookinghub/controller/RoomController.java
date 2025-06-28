package com.github.devmribeiro.bookinghub.controller;

@Deprecated
//@RestController
//@RequestMapping("/room")
public class RoomController {
//
//	private final RoomService service;
//
//	public RoomController(RoomService service) {
//		this.service = service;
//	}
//
//	@GetMapping("/{roomId}")
//	public @ResponseBody ResponseEntity<RoomResponseDTO> listById(@RequestParam("roomId") Integer roomId) {
//		return ResponseEntity.ok(new RoomResponseDTO(service.listById(roomId)));
//	}
//
//	@GetMapping("/list")
//	public @ResponseBody ResponseEntity<List<RoomResponseDTO>> list(
//			@RequestParam(value = "capacity", required = false) Integer capacity,
//			@RequestParam(value = "type", required = false) String type) {
//
//		List<Room> result = service.list(capacity, type);
//
//	    if (result == null || result.isEmpty())
//	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//
//	    List<RoomResponseDTO> response = result.stream()
//	            .map(room -> new RoomResponseDTO(room))
//	            .collect(Collectors.toList());
//
//	    return ResponseEntity.ok(response);
//	}
//
//	@PostMapping("/create")
//	public ResponseEntity<ApiResponse> create(@RequestBody RoomPostDTO dto) {
//	    Room createdRoom = service.create(dto.toEntity(dto));
//	    URI location = URI.create("/room/" + createdRoom.getRoomId());
//	    return 
//    		ResponseEntity
//    		.created(location)
//    		.body(new ApiResponse("Successfully Added Room", createdRoom.getRoomId()));
//	}
//
//	@PutMapping("/edit/{roomId}")
//	public ResponseEntity<RoomResponseDTO> edit(@PathVariable Integer roomId, @RequestBody RoomPostDTO dto) {
//		return ResponseEntity.ok(new RoomResponseDTO(service.edit(roomId, dto.toEntity(dto))));
//	}
//	
//	@DeleteMapping("delete/{roomId}")
//	public ResponseEntity<ApiResponse> delete(@PathVariable Integer roomId) {
//		service.delete(roomId);
//		return ResponseEntity.ok(new ApiResponse("Successfully Deleted Room", roomId));
//	}
}