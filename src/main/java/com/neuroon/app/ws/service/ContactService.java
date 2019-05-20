package com.neuroon.app.ws.service;

import java.util.List;

import com.neuroon.app.ws.shared.dto.ContactDto;

public interface ContactService {

	List<ContactDto> getContacts(String userId);

}
