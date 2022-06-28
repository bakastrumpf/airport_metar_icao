package com.esys.airMetarIcao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class IcaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code_id")
	private Integer id;
	
	@Column
	private String city;
	
	@Column
	private String code;

	public IcaoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IcaoEntity(Integer id, String city, String code) {
		super();
		this.id = id;
		this.city = city;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
