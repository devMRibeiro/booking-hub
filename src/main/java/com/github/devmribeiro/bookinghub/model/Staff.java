package com.github.devmribeiro.bookinghub.model;

import com.github.devmribeiro.bookinghub.abstracts.Person;
import com.github.devmribeiro.bookinghub.enums.Role;
import com.github.devmribeiro.bookinghub.util.Address;

public class Staff extends Person {

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