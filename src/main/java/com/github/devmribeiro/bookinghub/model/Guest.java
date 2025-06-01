package com.github.devmribeiro.bookinghub.model;

import java.time.LocalDateTime;
import java.util.List;

import com.github.devmribeiro.bookinghub.abstracts.Person;
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
@Table(name = "guest")
public class Guest extends Person {

	@Id
	@SequenceGenerator(name = "guest_id_seq", sequenceName = "guest_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_id_seq")
	@Column(name = "guest_id", updatable = false)
	private Integer guestId;
	
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

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
}