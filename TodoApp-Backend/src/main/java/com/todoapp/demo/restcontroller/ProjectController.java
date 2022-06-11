package com.todoapp.demo.restcontroller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.demo.domain.Project;
import com.todoapp.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> createProject( @RequestBody @Valid Project project, BindingResult result){
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
		Project savedProject = projectService.saveProject(project);
		
		return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
	}
}
