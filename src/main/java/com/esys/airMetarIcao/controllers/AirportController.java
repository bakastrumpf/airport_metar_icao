package com.esys.airMetarIcao.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esys.airMetarIcao.entities.AirportEntity;

@RestController
@RequestMapping("/airports")
public class AirportController {

	@RequestMapping("/hello")
	public String helloWorld() {
		return "prvi aerodrom";
	}
	
	private List<AirportEntity> getDB(){
		List<AirportEntity> airports = new ArrayList<AirportEntity>();
		airports.add(new AirportEntity(1, "Nikola Tesla", "Beograd", "LYBE"));
		airports.add(new AirportEntity(2, "Maksimir", "Zagreb", "LDDD"));
		airports.add(new AirportEntity(3, "International", "Frankfurt", "EDDF"));
		airports.add(new AirportEntity(4, "Schipol Airport", "Amsterdam", "EHAM"));
		return airports;
		
	}
	
	// TODO GET vrati sve aerodrome iz baze
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AirportEntity> getAll(){
		return getDB();
	}
	
	// TODO GET vrati 1 aerodrom /airports/{id}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AirportEntity getOne(@PathVariable Integer id) {
		for(AirportEntity ae : getDB()) {
			if(ae.getId().equals(id))
				return ae;
		}
		return null;
	}
	
	// TODO napravi novi aerodrom /airports/
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public AirportEntity createNewAirport (@RequestBody AirportEntity ae) {
		List<AirportEntity> airports = getDB();
		ae.setId((new Random()).nextInt());
		airports.add(ae);
		return ae;
	}
	
	// TODO PUT izmeni podatke o aerodromu /airports/{id}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public AirportEntity modifyAirport (@RequestBody AirportEntity modifiedAirport, 
			@PathVariable Integer id) {
		for(AirportEntity ae : getDB()) {
			if(ae.getId().equals(id)) {
				if(modifiedAirport.getIcao() != null)
					ae.setIcao(modifiedAirport.getIcao());
				if(modifiedAirport.getName() != null)
					ae.setName(modifiedAirport.getName());
				if(modifiedAirport.getCity() != null)
					ae.setCity(modifiedAirport.getCity());
				return ae;
			}
		}
		return null;
	}
	
	
	// TODO DELETE izbriši aerodrom /po id, po icao, po gradu/
	public AirportEntity deleteAirport (@PathVariable Integer id) {
		List<AirportEntity> airports = getDB();
		AirportEntity ae = getDB().stream().filter(x -> x.getId().equals(id)).findFirst().get();
		if (ae != null) {
			airports.remove(ae);
			return ae;
		}
		return null;
				
	}
}
