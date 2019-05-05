package com.neuroon.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuroon.app.ws.io.entity.AddressEntity;
import com.neuroon.app.ws.io.entity.UserEntity;
import com.neuroon.app.ws.io.repositories.AddressRepository;
import com.neuroon.app.ws.io.repositories.UserRepository;
import com.neuroon.app.ws.service.AddressService;
import com.neuroon.app.ws.shared.dto.AddressDto;

@Service
public class AddressServiceImlp implements AddressService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<AddressDto> getAddresses(String userId) {

		List<AddressDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			return returnValue;

		Iterable<AddressEntity> address = addressRepository.findAllByUserDetails(userEntity);

		for (AddressEntity addressEntity : address) {
			returnValue.add(modelMapper.map(addressEntity, AddressDto.class));
		}

		return returnValue;
	}

}
