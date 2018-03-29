package com.javarnd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/login")
@Api(value = "Contact Application manager", description = "User enter in Login controller ")
public class LoginRestController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/getLogin/{userId}/{password}")
	@ApiOperation(value = "User login method is called", response = Iterable.class)
	public GenericResponseDTO login(@PathVariable(value = "userId") String userId,
			@PathVariable(value = "password") String password) {
		GenericResponseDTO genericResponseDTO = null;
		genericResponseDTO = loginService.isUserAuthenticated(userId, password);
		return genericResponseDTO;
	}

}
