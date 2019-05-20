package com.neuroon.app.ws.io.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neuroon.app.ws.io.entity.AddressEntity;
import com.neuroon.app.ws.io.entity.ContactEntity;
import com.neuroon.app.ws.io.entity.UserEntity;

@Repository
public interface ContactRepository extends CrudRepository<AddressEntity, Long>{

	Iterable<ContactEntity> findAllByUserDetails(UserEntity userEntity);

}
