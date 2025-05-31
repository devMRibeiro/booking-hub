package com.github.devmribeiro.bookinghub.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@SequenceGenerator(name="room_id_seq", sequenceName="room_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_id_seq")
	@Column(name="room_id", updatable=false)
	private Integer roomId;

	private String label;
	private Integer capacity;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private Booking booking;

	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}