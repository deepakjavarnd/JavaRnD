package com.javarnd.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;
import com.javarnd.app.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value="Contact Application manager",description="User Enter in user controller ")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	@ApiOperation(value = "Save new user operation is called by user",response = Iterable.class)
	public GenericResponseDTO saveUserData(@Valid @RequestBody User user){
		GenericResponseDTO genericResponseDTO=null;
		genericResponseDTO=userService.saveUser(user);
		return genericResponseDTO;
		
	}
	
	
	@GetMapping("/getUserById/{id}")
	@ApiOperation(value = "Get single user by Id is method is called by user",response = Iterable.class)
	public User getUserById(@PathVariable(value="id") Integer id){
		
		return userService.getStudentById(id);

	}
	
	
	@DeleteMapping("/deleteUserById/{id}")
	@ApiOperation(value = "Delete single user by Id method is called by user",response = Iterable.class)
	public GenericResponseDTO deleteUserById(@PathVariable(value="id") Integer id){
		GenericResponseDTO genericResponseDTO=null;
		genericResponseDTO=userService.deleteUserById(id);
		return genericResponseDTO;
	}
	
	
	@DeleteMapping("/deleteAllUser")
	@ApiOperation(value = "Delete all use method is called by user",response = Iterable.class)
	public GenericResponseDTO getDeleteyId(){
		GenericResponseDTO genericResponseDTO=null;
		genericResponseDTO=userService.deleteAllUser();
		return genericResponseDTO;
	}
	
}
