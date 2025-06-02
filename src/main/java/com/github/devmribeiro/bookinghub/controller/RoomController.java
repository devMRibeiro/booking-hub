package com.github.devmribeiro.bookinghub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public @ResponseBody List<Room> listByType(@RequestParam(value = "type", required = false) String type) {
		return service.list(type);
	}
}