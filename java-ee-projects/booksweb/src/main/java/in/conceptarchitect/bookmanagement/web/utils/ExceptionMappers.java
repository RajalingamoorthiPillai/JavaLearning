package in.conceptarchitect.bookmanagement.web.utils;



import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.conceptarchitect.bookmanagement.entities.DuplicateEntityException;
import in.conceptarchitect.bookmanagement.entities.EntityNotFoundException;

@ControllerAdvice
public class ExceptionMappers {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public HashMap<String,Object> mapEntityNotFoundException(EntityNotFoundException ex) {
		var map=new HashMap<String,Object>();
		map.put("error",ex.getMessage());
		map.put("status",HttpStatus.NOT_FOUND);
		
		return map;
	}
	
	@ExceptionHandler(DuplicateEntityException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public HashMap<String,Object> mapDupicateEntityException(DuplicateEntityException ex) {
		var map=new HashMap<String,Object>();
		map.put("error",ex.getMessage());
		map.put("status",HttpStatus.BAD_REQUEST);
		
		return map;
	}
	
		
	

}
