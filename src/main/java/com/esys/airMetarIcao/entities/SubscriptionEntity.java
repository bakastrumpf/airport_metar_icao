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

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@SQLDelete(sql = "UPDATE check_list_item_template SET active = false WHERE id=?")

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class SubscriptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private boolean active = Boolean.TRUE;

	private String icaoCode;

	public SubscriptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubscriptionEntity(Integer id, String icaoCode) {
		super();
		this.id = id;
		this.icaoCode = icaoCode;
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

	public static void deleteById(Integer id2) {
		// TODO Auto-generated method stub
		
	}

}
