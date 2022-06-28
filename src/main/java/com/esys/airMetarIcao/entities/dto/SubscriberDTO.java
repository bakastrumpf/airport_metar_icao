package com.esys.airMetarIcao.entities.dto;

public class SubscriberDTO {
	
	private String subscriber;
	
	public SubscriberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SubscriberDTO(String subscriber, String token) {
		super();
		this.subscriber = subscriber;
	}


	public String getSubscriber() {
		return subscriber;
	}


	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	

}
