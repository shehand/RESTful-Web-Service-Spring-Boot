package com.neuroon.app.ws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuroon.app.ws.service.AddressService;
import com.neuroon.app.ws.service.UserService;
import com.neuroon.app.ws.shared.dto.AddressDto;
import com.neuroon.app.ws.shared.dto.UserDto;
import com.neuroon.app.ws.ui.model.request.UserDetailsRequestModelBody;
import com.neuroon.app.ws.ui.model.response.AddressesRest;
import com.neuroon.app.ws.ui.model.response.OperationStatus;
import com.neuroon.app.ws.ui.model.response.RequestOperaionStatus;
import com.neuroon.app.ws.ui.model.response.RequestOperationName;
import com.neuroon.app.ws.ui.model.response.UserRest;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@ApiOperation(value = "The Get User Details Web Service Endpoint",
			notes = "This web service endpoint returns the User detials with json array or xml format")
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest getUser(@PathVariable String id) {

		UserRest returnValue = new UserRest();

		UserDto userDto = userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);

		return returnValue;
	}
	
	@ApiOperation(value = "The User Registration Web Service Endpoint",
			notes = "This web service endpoint returns the User detials with json array or xml format when the user is created")
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest createUser(@RequestBody UserDetailsRequestModelBody userDetails) {
		UserRest returnValue = new UserRest();

//		UserDto userDto = new UserDto();
//		BeanUtils.copyProperties(userDetails, userDto);
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		UserDto createUser = userService.createUser(userDto);
		returnValue = modelMapper.map(createUser, UserRest.class);

		return returnValue;
	}

	@ApiOperation(value = "The User Details Update Web Service Endpoint",
			notes = "This web service endpoint returns the User detials or success message with json array or xml format when the user is updated")
	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModelBody userDetails) {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(createUser, returnValue);

		return returnValue;
	}

	@ApiOperation(value = "The User Deletion Web Service Endpoint",
			notes = "This web service endpoint returns success token with json array or xml format when the user is deleted")
	@DeleteMapping(path = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatus deleteUser(@PathVariable String id) {

		OperationStatus returnValue = new OperationStatus();
		returnValue.setOperationName(RequestOperationName.DELETE.name());

		userService.deleteUser(id);

		returnValue.setOperationResult(RequestOperaionStatus.SUCCESS.name());
		return returnValue;
	}

	@ApiOperation(value = "The Get Users Web Service Endpoint",
			notes = "This web service endpoint returns List of User detials with json array or xml format")
	@ApiImplicitParams({
		@ApiImplicitParam(name="authorization", value="Bearer JWT Token", paramType = "header")
		
	})
	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		List<UserRest> returnValue = new ArrayList<>();

		List<UserDto> users = userService.getUsers(page, limit);

		for (UserDto userDto : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
	}

	// http://localhost:8080/users/<user_id>/addresses/
	@ApiOperation(value = "The Get User Addresses Web Service Endpoint",
			notes = "This web service endpoint returns List of User Addresses detials with json array or xml format")
	@GetMapping(path = "/{id}/addresses", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<AddressesRest> getUserAddresses(@PathVariable String id) {

		List<AddressesRest> returnValue = new ArrayList<>();

		List<AddressDto> addressDto = addressService.getAddresses(id);

		if (addressDto != null && !addressDto.isEmpty()) {
			java.lang.reflect.Type listMapper = new TypeToken<List<AddressesRest>>() {
			}.getType();
			returnValue = new ModelMapper().map(addressDto, listMapper);
		}
		return returnValue;
	}

	// http://localhost:8080/users/<user_id>/addresses/<address_id>
	@ApiOperation(value = "The Get User Addresse Web Service Endpoint",
			notes = "This web service endpoint returns the User's selected Addresse according to the given address Id detials with json array or xml format")
	@GetMapping(path = "/{userId}/addresses/{addressId}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public AddressesRest getUserAddress(@PathVariable String userId, @PathVariable String addressId) {

		AddressDto addressDto = addressService.getAddress(addressId);
		
		ModelMapper modelMapper = new ModelMapper();
		Link addressLink = linkTo(UserController.class).slash(userId).slash("addresses").slash(addressId).withSelfRel();
		Link userLink = linkTo(UserController.class).slash(userId).withRel("user");
		Link addressesLink = linkTo(UserController.class).slash(userId).slash("addresses").withRel("addresses");
		
		AddressesRest addressRestModel = modelMapper.map(addressDto, AddressesRest.class);
		
		addressRestModel.add(addressLink);
		addressRestModel.add(userLink);
		addressRestModel.add(addressesLink);
		
		return addressRestModel;
	}
}
