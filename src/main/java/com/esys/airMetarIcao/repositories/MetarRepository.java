package com.esys.airMetarIcao.repositories;

import org.springframework.data.repository.CrudRepository;

import com.esys.airMetarIcao.entities.MetarEntity;

public interface MetarRepository extends CrudRepository<MetarEntity, Integer> {

}
