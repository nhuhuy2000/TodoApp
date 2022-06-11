package com.todoapp.demo.service;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MapValidationErrorService {
	
	public ResponseEntity<?> mapValidationService(BindingResult result){
		if(result.hasErrors()) {
			HashMap<String, String> errors = new HashMap<>();
			
			result.getFieldErrors().forEach(
					error -> errors.put(error.getField(), error.getDefaultMessage()));
			String errorMessage = "";
			for(String key : errors.keySet()) {
				errorMessage += "Lỗi ở: " + key + " Lí do : " + errors.get(key) + "\n";
			}
			return new ResponseEntity<String>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
