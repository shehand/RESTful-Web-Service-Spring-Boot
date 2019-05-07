package com.neuroon.app.ws.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuroon.app.ws.ui.model.request.LoginRequestModel;

@RestController
public class AuthenticationController {

	@PostMapping("/login")
	public void theFakeLogin(@RequestBody LoginRequestModel loginRequestModel) {
		throw new IllegalStateException("This method should not be called. The method is implemented by Spring Security");
	}
}
