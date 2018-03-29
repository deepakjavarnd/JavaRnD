package com.javarnd.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="User_Id")
private Integer userId;

@NotNull
@Column(name="User_Name",unique=true,nullable=false)
private String userName;

@NotNull
@Column(name = "password",nullable=false)
private String password;

@NotNull
@Column(name="User_Address")
private String userAddress;

@NotNull
@Size(min=10,max=10)
@Column(name="User_Contact",nullable=false)
private String userContact;

@NotNull
@Column(name = "email")
private String email;

@NotNull
@Column(name = "status",nullable=false)
private int status;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(name = "user_role", joinColumns =  @JoinColumn(name = "User_id"), inverseJoinColumns = @JoinColumn(name = "Role_id"))
private Set<Role> roles;

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserAddress() {
	return userAddress;
}

public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}

public String getUserContact() {
	return userContact;
}

public void setUserContact(String userContact) {
	this.userContact = userContact;
}
}
