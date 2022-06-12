package com.todoapp.demo.service;

import java.util.List;

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
	public Project getProjectByIdentifier(String idIdentifier) {

			Project project =  projectRepository.findByProjectIdentifer(idIdentifier);
			if(project == null) {
				
				throw new ProjectIdException("Project Identifier: '" + idIdentifier + "' không tìm thấy!");
			}
	
		return project;
	}
	public List<Project> getAllProject(){
		return projectRepository.findAll();
	}
	public void deleteByProjectId(String projectIdentifier) {
		Project project = projectRepository.findByProjectIdentifer(projectIdentifier);
		
		if(project == null) {
			throw new ProjectIdException("Project voi projectIdentifier '" + projectIdentifier + "' khong ton tai!");
		}
		projectRepository.deleteById(project.getId());
		
	}
	
}
