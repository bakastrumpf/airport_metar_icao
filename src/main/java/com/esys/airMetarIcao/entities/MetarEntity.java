package com.esys.airMetarIcao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class MetarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String weather;

	public MetarEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MetarEntity(Integer id, String weather) {
		super();
		this.id = id;
		this.weather = weather;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	

}
