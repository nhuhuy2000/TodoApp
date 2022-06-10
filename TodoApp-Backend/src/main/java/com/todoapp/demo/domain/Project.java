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
	@Column(name = "project_name")
	@NotBlank(message = "Tên project không thể để trống")
	private String projectName;
	@NotBlank(message = "Project identifier không thể để trống")
	@Size(min = 3, max = 5 , message = "Phải nhỏ hơn 5 và lớn hơn 3" )
	@Column(name = "project_identifier", updatable = false, unique = true)
	private String projectIdentifer;
	@NotBlank(message = "Description không thể để trống")
	private String description;
	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startDate;
	@Column(name = "end_date")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date endDate;
	@Column(name = "created_time")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdTime;
	@Column(name = "updated_time")
	@JsonFormat(pattern = "yyyy-mm-dd")
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
