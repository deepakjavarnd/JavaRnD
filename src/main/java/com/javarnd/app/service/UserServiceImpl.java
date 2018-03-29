package com.javarnd.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.app.comman.Constants;
import com.javarnd.app.dto.GenericResponseDTO;
import com.javarnd.app.model.User;
import com.javarnd.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public GenericResponseDTO saveUser(User user) {
		GenericResponseDTO genericResponseDTO = null;
		List<Object> data = null;
		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.FAILURE);
		genericResponseDTO.setStatusCode(Constants.ERRO_CODE);
		genericResponseDTO.setMessage(Constants.FAILURE_NESSAGE);

		userRepository.save(user);

		genericResponseDTO.setStatus(Constants.SUCCESS);
		genericResponseDTO.setStatusCode(Constants.SUCCESS_CODE);
		genericResponseDTO.setMessage(Constants.SUCCESS_MESSAGE);
		data = new ArrayList<Object>();
		data.add(user);
		genericResponseDTO.setData(data);

		return genericResponseDTO;
	}

	@Override
	public User getStudentById(Integer id) {

		return userRepository.findOne(id);

	}

	@Override
	public GenericResponseDTO deleteUserById(Integer id) {
		GenericResponseDTO genericResponseDTO = null;
		List<Object> data = null;

		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.FAILURE);
		genericResponseDTO.setStatusCode(Constants.ERRO_CODE);
		genericResponseDTO.setMessage(Constants.DELET_FAILURE_MESSAGE);

		userRepository.delete(id);

		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.SUCCESS);
		genericResponseDTO.setStatusCode(Constants.SUCCESS_CODE);
		genericResponseDTO.setMessage(Constants.DELET_SUCCESS_MESSAGE);
		data = new ArrayList<Object>();
		data.add(id);
		genericResponseDTO.setData(data);

		return genericResponseDTO;
	}

	@Override
	public GenericResponseDTO deleteAllUser() {
		GenericResponseDTO genericResponseDTO = null;

		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.FAILURE);
		genericResponseDTO.setStatusCode(Constants.ERRO_CODE);
		genericResponseDTO.setMessage(Constants.DELET_FAILURE_MESSAGE);

		userRepository.deleteAll();

		genericResponseDTO = new GenericResponseDTO();
		genericResponseDTO.setStatus(Constants.SUCCESS);
		genericResponseDTO.setStatusCode(Constants.SUCCESS_CODE);
		genericResponseDTO.setMessage(Constants.DELET_SUCCESS_MESSAGE);

		return genericResponseDTO;
	}

}
