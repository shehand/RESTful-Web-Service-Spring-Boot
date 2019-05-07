package com.neuroon.app.ws.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.neuroon.app.ws.io.entity.UserEntity;
import com.neuroon.app.ws.io.repositories.UserRepository;

class UserServiceImplTest {
	
	@Mock
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetUser() {
		UserEntity userEntity = new UserEntity();
		
		userEntity.setId(1L);
		userEntity.setFirstName("test user");
		userEntity.setLastName("testing");
		userEntity.setUserId("safs5daf45sadf6a4sdf");
		userEntity.setEncryptedPassword("asdfsadasdfsa456sa4f6s5d4fs");
		
		when( userRepository.findByEmail(anyString()) ).thenReturn( userEntity );
	}

}
