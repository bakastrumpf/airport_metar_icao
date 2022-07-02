package com.esys.airMetarIcao.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esys.airMetarIcao.entities.SubscriptionEntity;
import com.esys.airMetarIcao.repositories.MetarRepository;

@RestController
@RequestMapping(path = "/metar")
public class MetarController {

	@Autowired
	private MetarRepository metarRepository;

	public static void readBashScript() {
		try {
			Process proc = Runtime.getRuntime().exec("/home/montekrista/metar-script.sh /"); 																							
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getMetarData() {
		
		
		return null; //metarData
	}
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<SubscriptionEntity> getAll() {
		List<SubscriptionEntity> entities = (List<SubscriptionEntity>) repository.findAll();
		return entities;

	}
	 */

}
