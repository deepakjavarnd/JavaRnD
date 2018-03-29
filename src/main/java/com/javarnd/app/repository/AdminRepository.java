package com.javarnd.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
public interface AdminRepository extends CrudRepository<User, Integer> {
	/**
	 * @purpose this is a custom JPA method declaration
	 * and it will be implemented at runtime by JVM Using Spring JPA.
	 * 
	 */
	@Modifying(clearAutomatically = true)
	@Query("UPDATE User s SET s.status = :status WHERE s.userId = :userId")
	public Integer disableUser(String userId,String status);

}
