package com.todoapp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.demo.domain.Project;
import com.todoapp.demo.exceptions.ProjectIdException;
import com.todoapp.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		try {
			return projectRepository.save(project);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ProjectIdException("Project Id '"+ project.getProjectIdentifer().toUpperCase() + "' đã tồn tại ! ");
		}
	}
}
