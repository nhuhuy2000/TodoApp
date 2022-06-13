package com.todoapp.demo.restcontroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.demo.domain.Project;
import com.todoapp.demo.service.MapValidationErrorService;
import com.todoapp.demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createProject( @RequestBody @Valid Project project, BindingResult result){
		ResponseEntity<?> errors = mapValidationErrorService.mapValidationService(result);
		if(errors != null) return errors;
		
		Project savedProject = projectService.saveProject(project);
		
		return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
	}
	@GetMapping("/{projectIdentifier}")
	public ResponseEntity<Project> getProjectByIdentifier(@PathVariable("projectIdentifier") String idIdentifier){
		Project project = projectService.getProjectByIdentifier(idIdentifier);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Project>> getListProject(){
		List<Project> list = projectService.getAllProject();
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{projectIdentifier}")
	public ResponseEntity<String> deleteByProjectId(@PathVariable("projectIdentifier") String projectIdentifier){
		projectService.deleteByProjectId(projectIdentifier);
		String messageString = "Da xoa thanh cong project voi id : "+ projectIdentifier;
		return new ResponseEntity<String>(messageString, HttpStatus.OK);
	}
	@PutMapping("/update/{projectIdentifier}")
	public ResponseEntity<?> updateProject(@RequestBody @Valid Project project,@PathVariable("projectIdentifier") String projectIdentifier, BindingResult result){
		ResponseEntity<?> errors = mapValidationErrorService.mapValidationService(result);
		if(errors != null) {
			return errors;
		}
		Project project2 = projectService.getProjectByIdentifier(projectIdentifier);
		
		project2.setProjectName(project.getProjectName());
		project2.setDescription(project.getDescription());
		project2.setUpdatedTime(new Date());
		
		Project savedProject = projectService.saveProject(project2);
		
		return new ResponseEntity<Project>(savedProject, HttpStatus.CREATED);
	}
}
