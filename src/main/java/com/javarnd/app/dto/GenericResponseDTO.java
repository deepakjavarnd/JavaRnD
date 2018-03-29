package com.javarnd.app.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)//Null properties will not be included in JSON response
@JsonPropertyOrder({ "status", "statusCode", "message", "data" })//This order will be followed in JSON response
public class GenericResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 404L;

	@JsonProperty("STATUS")
	private String status;

	@JsonProperty("STATUSCODE")
	private String statusCode;

	@JsonProperty("MESSAGE")
	private String message;

	@JsonProperty("DATA")
	private List<Object> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
