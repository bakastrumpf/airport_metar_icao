package com.esys.airMetarIcao.entities;


public class AirportEntity {
	
	private Integer id;
	
	private String name;
	
	private String city;
	
	private String icao;

	public AirportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirportEntity(Integer id, String name, String city, String icao) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.icao = icao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}
	
	

}
