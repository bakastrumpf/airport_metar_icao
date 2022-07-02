package com.esys.airMetarIcao.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.esys.airMetarIcao.entities.dto.SubscriptionDTO;

public class SubscriptionCustomValidator implements Validator {
	
	@Override
	public boolean supports(Class <?> myClass) {
		return SubscriptionDTO.class.equals(myClass);
		}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		SubscriptionDTO sub = (SubscriptionDTO) target;
		if(!sub.getIcaoCode().equals(sub.getIcaoCode())) {
			errors.reject("400", "Icao code already exists. Please, review!");
		}
	}

}
