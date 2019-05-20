package com.neuroon.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuroon.app.ws.io.entity.ContactEntity;
import com.neuroon.app.ws.io.entity.UserEntity;
import com.neuroon.app.ws.io.repositories.ContactRepository;
import com.neuroon.app.ws.io.repositories.UserRepository;
import com.neuroon.app.ws.service.ContactService;
import com.neuroon.app.ws.shared.dto.ContactDto;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public List<ContactDto> getContacts(String userId) {

		List<ContactDto> returnValue = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();

		UserEntity userEntity = userRepository.findByUserId(userId);
		if (userEntity == null)
			return returnValue;

		Iterable<ContactEntity> address = contactRepository.findAllByUserDetails(userEntity);

		for (ContactEntity contactEntity : address) {
			returnValue.add(modelMapper.map(contactEntity, ContactDto.class));
		}

		return returnValue;
	}
}
