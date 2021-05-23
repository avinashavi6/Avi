package com.capgeminijpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name = "coursedetails")
public class Course {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;

	// Set, List or Map
	@ManyToMany
	@JoinTable(name = "Trainee_Course", joinColumns = { @JoinColumn(name = "courseId") }, inverseJoinColumns = {
			@JoinColumn(name = "traineeId") })
	private Set<Trainee> traineeSet = new HashSet<Trainee>();

	public Course() {
	}

	public Course(int courseId, String courseName, Set<Trainee> traineeSet) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.traineeSet = traineeSet;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Trainee> getTraineeSet() {
		return traineeSet;
	}

	public void setTraineeSet(Set<Trainee> traineeSet) {
		this.traineeSet = traineeSet;
	}

}
