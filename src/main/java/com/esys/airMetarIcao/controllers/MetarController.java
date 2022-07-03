package com.esys.airMetarIcao.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esys.airMetarIcao.entities.MetarEntity;
import com.esys.airMetarIcao.entities.SubscriptionEntity;
import com.esys.airMetarIcao.entities.dto.MetarDTO;
import com.esys.airMetarIcao.repositories.MetarRepository;

@RestController
@RequestMapping(path = "/airport")
public class MetarController {

	@Autowired
	private MetarRepository metarRepository;

	public static void readBashScript() {
		try {
			Process proc = Runtime.getRuntime().exec("/home/montekrista/metar-script.sh/");
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

	@RequestMapping(method = RequestMethod.GET, value = "/data")
	public List<MetarEntity> getMetarData() {
		List<MetarEntity> metarData = (List<MetarEntity>) metarRepository.findAll();
		return metarData;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{icaoCode}/METAR")
	public ResponseEntity<?> saveMetarData(@PathVariable String icaoCode, @RequestBody MetarDTO metarDTO) {

		MetarEntity metarEntity = new MetarEntity();
		metarEntity.setData(metarDTO.getData());
		metarEntity.setIcaoCode(icaoCode);
		metarRepository.save(metarEntity);
		return new ResponseEntity<>(metarDTO, HttpStatus.OK);
	}
}
