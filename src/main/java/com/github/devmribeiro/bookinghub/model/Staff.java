package com.github.devmribeiro.bookinghub.model;

import com.github.devmribeiro.bookinghub.abstracts.Person;
import com.github.devmribeiro.bookinghub.enums.Role;
import com.github.devmribeiro.bookinghub.util.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff extends Person {

	@Id
	@SequenceGenerator(name = "staff_id_seq", sequenceName = "staff_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_id_seq")
	@Column(name = "staff_id", updatable = false)
	private Integer staffId;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	private Role role;

	public Staff(String name, String document, String email, String phone, String birthDate, Address address) {
		super(name, document, email, phone, birthDate, address);
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}