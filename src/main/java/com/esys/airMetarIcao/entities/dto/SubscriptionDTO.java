package com.esys.airMetarIcao.entities.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubscriptionDTO {

	@AssertTrue
	private boolean active = Boolean.TRUE;
	
	@NotNull(message = "Icao code must be provided.")
	@Size(min = 4, max = 4, message = "Icao code must be between {min} and {max} characters long.")
	private String icaoCode;

	public SubscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubscriptionDTO(boolean active, String icaoCode) {
		super();
		this.active = active;
		this.icaoCode = icaoCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
