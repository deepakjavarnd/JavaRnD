package com.javarnd.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javarnd.app.model.User;
/**
 * @purpose this is JPA Repository and Spring JPA provide common method implementation at run time
 * like save(),findOne(),findAll(),delete(),deleteAll().
 * User does not need to write implementation of these classes Spring JPA provide it at runtime
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
