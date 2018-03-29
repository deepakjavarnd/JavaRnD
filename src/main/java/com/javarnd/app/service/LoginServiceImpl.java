package com.javarnd.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.app.comman.Constants;
import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public GenericResponseDTO isUserAuthenticated(String userName, String password) {
		int flag=0;
		GenericResponseDTO genericResponseDTO = null;
		List<Object> data = null;
		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.FAILURE);
		genericResponseDTO.setStatusCode(Constants.ERRO_CODE);
		genericResponseDTO.setMessage(Constants.USER_FOUND_MESSAGE);
		flag=loginRepository.isUserAuthenticated(userName, password);
		
		if(flag>0) {
			genericResponseDTO.setStatus(Constants.SUCCESS);
			genericResponseDTO.setStatusCode(Constants.SUCCESS_CODE);
			genericResponseDTO.setMessage(Constants.USER_FOUND_MESSAGE);
			data = new ArrayList<Object>();
			data.add(userName);
			genericResponseDTO.setData(data);
		}
		
		return genericResponseDTO;
	}

}
