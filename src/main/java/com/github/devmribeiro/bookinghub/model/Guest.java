package com.github.devmribeiro.bookinghub.model;

import java.time.LocalDateTime;

import com.github.devmribeiro.bookinghub.abstracts.Person;
import com.github.devmribeiro.bookinghub.util.Address;

public class Guest extends Person {

	private LocalDateTime checkIn;

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