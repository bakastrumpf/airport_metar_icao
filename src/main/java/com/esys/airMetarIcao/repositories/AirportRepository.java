package com.esys.airMetarIcao.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esys.airMetarIcao.entities.AirportEntity;

public interface AirportRepository extends CrudRepository<AirportEntity, Integer> {

}
