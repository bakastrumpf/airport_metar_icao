package com.esys.airMetarIcao.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esys.airMetarIcao.entities.IcaoEntity;

public interface IcaoRepository extends CrudRepository<IcaoEntity, Integer> {

}
