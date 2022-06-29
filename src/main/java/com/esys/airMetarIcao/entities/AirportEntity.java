package com.esys.airMetarIcao.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class AirportEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String city;

	@JsonIgnore
	@OneToOne(mappedBy = "airport", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private IcaoEntity icao;

	public AirportEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirportEntity(Integer id, String name, String city, IcaoEntity icao) {
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

	public IcaoEntity getIcao() {
		return icao;
	}

	public void setIcao(IcaoEntity icao) {
		this.icao = icao;
	}

}
