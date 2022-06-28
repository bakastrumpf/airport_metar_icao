package com.esys.airMetarIcao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class AirportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "airport_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "icao_code")
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
