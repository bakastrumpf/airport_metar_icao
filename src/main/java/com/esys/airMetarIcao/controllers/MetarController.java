package com.esys.airMetarIcao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esys.airMetarIcao.repositories.MetarRepository;

@RestController
@RequestMapping(path = "/metars")
public class MetarController {

	@Autowired
	private MetarRepository metarRepository;

	}
