package com.javarnd.app.service;

import com.javarnd.app.dto.GenericResponseDTO;

public interface LoginService {

	public GenericResponseDTO isUserAuthenticated(String userName, String password);

	
}
