package com.javarnd.app.service;

import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;

public interface UserService {

	public GenericResponseDTO saveUser(User user);

	public User getStudentById(Integer id);
	
	public GenericResponseDTO deleteUserById(Integer id);
	
	public GenericResponseDTO deleteAllUser();
	
}
