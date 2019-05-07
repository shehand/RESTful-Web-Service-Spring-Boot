package com.neuroon.app.ws.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.neuroon.app.ws.io.entity.UserEntity;
import com.neuroon.app.ws.io.repositories.UserRepository;
import com.neuroon.app.ws.shared.dto.UserDto;

class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetUser() {
		UserEntity userEntity = new UserEntity();

		userEntity.setId(1L);
		userEntity.setFirstName("sfv");
		userEntity.setUserId("safs5daf");
		userEntity.setEncryptedPassword("asdfsadasds5d4fs");

		when(userRepository.findByEmail(anyString())).thenReturn(userEntity);

		UserDto userDto = userService.getUser("test@test.com");

		assertNotNull(userDto);
		assertEquals("testing", userDto.getLastName());
	}

}
