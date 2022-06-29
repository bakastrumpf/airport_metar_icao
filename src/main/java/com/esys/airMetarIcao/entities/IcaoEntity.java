package com.esys.airMetarIcao.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Table
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class IcaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@JsonIgnore
	
	private String code;
@OneToOne
@JoinColumn(name="airport_id")
	private AirportEntity airport;




	@Column
	private String city;




	public IcaoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public IcaoEntity(Integer id, String code, AirportEntity airport, String city) {
		super();
		this.id = id;
		this.code = code;
		this.airport = airport;
		this.city = city;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public AirportEntity getAirport() {
		return airport;
	}




	public void setAirport(AirportEntity airport) {
		this.airport = airport;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}

	
	
	
}
