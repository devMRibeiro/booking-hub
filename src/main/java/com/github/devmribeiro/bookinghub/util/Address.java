package com.github.devmribeiro.bookinghub.util;

import jakarta.persistence.Embeddable;

public @Embeddable record Address(
	String street,
	String streetNumber,
	String complement,
	String city,
	String postalCode,
	String state,
	String country
) { }