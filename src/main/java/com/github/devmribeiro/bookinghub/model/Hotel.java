package com.github.devmribeiro.bookinghub.model;

import java.util.List;

import com.github.devmribeiro.bookinghub.util.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@SequenceGenerator(name = "hotel_id_seq", sequenceName = "hotel_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_id_seq")
	@Column(name = "hotel_id")
	private Integer hotelId;
	
	private String name;
	private Integer roomQuantity;
	private Address address;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Staff> staffList;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Room> roomList;
	
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