package com.github.devmribeiro.bookinghub.model;

import com.github.devmribeiro.bookinghub.util.Address;

public class Hotel {
	private Integer hotelId;
	private String name;
	private Integer roomQuantity;
	private Address address;

	public Hotel(Integer hotelId, String name, Integer roomQuantity, Address address) {
		this.hotelId = hotelId;
		this.name = name;
		this.roomQuantity = roomQuantity;
		this.address = address;
	}

	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRoomQuantity() {
		return roomQuantity;
	}
	public void setRoomQuantity(Integer roomQuantity) {
		this.roomQuantity = roomQuantity;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}