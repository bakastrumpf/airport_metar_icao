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
	
	private String icaoCode;
	
	private String data;
		
	public MetarEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MetarEntity(Integer id, String icaoCode, String data) {
		super();
		this.id = id;
		this.icaoCode = icaoCode;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcaoCode() {
		return icaoCode;
	}

	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
