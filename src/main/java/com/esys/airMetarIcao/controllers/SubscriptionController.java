package com.esys.airMetarIcao.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esys.airMetarIcao.entities.SubscriptionEntity;
import com.esys.airMetarIcao.entities.dto.SubscriptionDTO;
import com.esys.airMetarIcao.repositories.SubscriptionsRepository;
import com.esys.airMetarIcao.utils.SubscriptionCustomValidator;

@RestController
@RequestMapping(path = "/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionsRepository repository;

//	@Autowired
	private SubscriptionCustomValidator subValidator;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators(subValidator);
	}

	@RequestMapping("/hello")
	public String helloWorld() {
		return "prvi aerodrom";
	}

	List<SubscriptionEntity> airports = new ArrayList<SubscriptionEntity>();

	private List<SubscriptionEntity> getDB() {
		if (airports.size() == 0) {
			airports.add(new SubscriptionEntity());

		}
		return airports;
	}

	// TODO GET vrati sve subs iz baze
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<SubscriptionEntity> getAll() {
		List<SubscriptionEntity> entities = (List<SubscriptionEntity>) repository.findAll();
		return entities;

	}

	// TODO GET vrati 1 sub /airports/{id}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public List<SubscriptionEntity> getOne(@PathVariable Integer id) {
		for (SubscriptionEntity se : getDB()) {
			// getId set to null?
			if (se.getId().equals(id))
				return (List<SubscriptionEntity>) se;
		}
		return null;
	}

	// TODO new subscription
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewSubscription(@Valid @RequestBody SubscriptionDTO newSubscription,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		} else {
			subValidator.validate(newSubscription, result);
		}
		SubscriptionEntity sub = new SubscriptionEntity();
		sub.setIcaoCode(newSubscription.getIcaoCode());
		repository.save(sub);
		return new ResponseEntity<>(newSubscription, HttpStatus.OK);
	}

	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}

	// TODO DELETE izbriši prijavu /po id/ soft del
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
	public ResponseEntity<SubscriptionEntity> delSub(@PathVariable Integer id) {
		if (repository.findById(id) == null) {
			throw new NoSuchElementException("Item doesn't exists or is already deleted!");
		}
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
