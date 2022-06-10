package com.todoapp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.demo.domain.Project;
import com.todoapp.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		Project savedProject = projectRepository.save(project);
		return savedProject;
	}
}
