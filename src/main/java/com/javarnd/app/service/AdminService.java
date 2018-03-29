package com.javarnd.app.service;

import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;

public interface AdminService {


	public Iterable<User> getAllUser();
	
	public GenericResponseDTO disableUser(String userId, String status);

}
