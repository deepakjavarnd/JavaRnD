package com.javarnd.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.app.comman.Constants;
import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;
import com.javarnd.app.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	public AdminRepository adminRepository;
	
	@Override
	public Iterable<User> getAllUser() {
		return adminRepository.findAll();
	}

	@Override
	public GenericResponseDTO disableUser(String userId, String status) {
		Integer flag = null;
		GenericResponseDTO genericResponseDTO = null;
		List<Object> data = null;
		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.FAILURE);
		genericResponseDTO.setStatusCode(Constants.ERRO_CODE);
		genericResponseDTO.setMessage(Constants.DISABLE_FAILURE_MESSAGE);

		flag = adminRepository.disableUser(userId, status);

		if (flag > 0) {
			genericResponseDTO.setStatus(Constants.SUCCESS);
			genericResponseDTO.setStatusCode(Constants.SUCCESS_CODE);
			genericResponseDTO.setMessage(Constants.SUCCESS_MESSAGE);
			data = new ArrayList<Object>();
			data.add(userId);
			genericResponseDTO.setData(data);
		}
		
		return genericResponseDTO;
	}

}
