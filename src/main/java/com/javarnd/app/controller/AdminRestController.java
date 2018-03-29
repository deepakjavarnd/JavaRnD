package com.javarnd.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;
import com.javarnd.app.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api(value="Contact Application manager",description="Admin Enter in admin controller ")

public class AdminRestController {
	
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/getAllUser")
	@ApiOperation(value = "Get all user methos is called by admin",response = Iterable.class)
	public Iterable<User> getAllUserData(){
		
		return adminService.getAllUser();
	}
	
	@PutMapping("/disableUserByUserId/{userId}/{status}")
	@ApiOperation(value = "Disable user method is called by admin",response = Iterable.class)
	public GenericResponseDTO disableUserByUserId(@PathVariable(value="userIdd") String userId,@PathVariable(value="status") String status){
		GenericResponseDTO genericResponseDTO=null;
		genericResponseDTO=adminService.disableUser(userId, status);
		return genericResponseDTO;
	}
	
}
