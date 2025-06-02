package com.github.devmribeiro.bookinghub.abstracts;

import com.github.devmribeiro.bookinghub.util.Address;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	private String name;
	private String document;
	private String email;
	private String phone;
	private String birthDate;
	private @Embedded Address address;

	public Person(String name, String document, String email, String phone, String birthDate, Address address) {
		this.name = name;
		this.document = document;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}