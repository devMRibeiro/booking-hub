package com.github.devmribeiro.bookinghub.model;

import java.time.LocalDateTime;
import java.util.List;

import com.github.devmribeiro.bookinghub.abstracts.Person;
import com.github.devmribeiro.bookinghub.util.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public class Guest extends Person {

	private LocalDateTime checkIn;

	@OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
	private List<Booking> bookings;

	public Guest(String name, String document, String email, String phone, String birthDate, Address address) {
		super(name, document, email, phone, birthDate, address);
	}

	public LocalDateTime getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}
}