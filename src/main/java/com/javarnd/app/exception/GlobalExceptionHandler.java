package com.javarnd.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @purpose This is a generic Exception Handler class witch handle all Exception
 *          occur in any controller class but right now in this application
 *          there is only one Controller class
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @purpose This is a generic Exception Handler method witch handle all
	 *          Exception occur in any controller class we can define any number of
	 *          Exception Handler method but I just define one method with Exception
	 *          class witch can handle any Exception.
	 * 
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handelException(Exception exception) {
		ModelAndView model = new ModelAndView("Exception");
		model.addObject("message", exception.getMessage());
		return model;
	}

}
