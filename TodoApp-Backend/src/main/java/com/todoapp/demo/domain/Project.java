package com.todoapp.demo.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Tên project không thể để trống")
	@Column(name = "project_name")
	private String projectName;
	 @NotBlank(message ="Project Identifier is required")
	 @Size(min=4, max=5, message = "Please use 4 to 5 characters")
	 @Column(updatable = false, unique = true)
	private String projectIdentifer;
	@NotBlank(message = "Description không thể để trống")
	private String description;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "start_date")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "end_date")
	private Date endDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "created_time")
	private Date createdTime;
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(name = "updated_time")
	private Date updatedTime;
	//Getter and Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectIdentifer() {
		return projectIdentifer;
	}
	public void setProjectIdentifer(String projectIdentifer) {
		this.projectIdentifer = projectIdentifer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	//constructor
	public Project() {
		super();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(createdTime, description, endDate, id, projectIdentifer, projectName, startDate,
				updatedTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(createdTime, other.createdTime) && Objects.equals(description, other.description)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(projectIdentifer, other.projectIdentifer)
				&& Objects.equals(projectName, other.projectName) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(updatedTime, other.updatedTime);
	}
	//toString
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", projectIdentifer=" + projectIdentifer
				+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";
	}
	
	@PrePersist// trước khi tạo 1 đối tượng thì 
	protected void onCreate() {
		this.createdTime = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedTime = new Date();
	}
	
}

