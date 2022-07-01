package com.esys.airMetarIcao.repositories;

import org.springframework.data.repository.CrudRepository;
import com.esys.airMetarIcao.entities.SubscriptionEntity;

public interface SubscriptionsRepository extends CrudRepository<SubscriptionEntity, Integer> {


}
