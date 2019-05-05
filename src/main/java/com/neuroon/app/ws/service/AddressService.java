package com.neuroon.app.ws.service;

import java.util.List;

import com.neuroon.app.ws.shared.dto.AddressDto;

public interface AddressService {

	List<AddressDto> getAddresses(String userId);
}
