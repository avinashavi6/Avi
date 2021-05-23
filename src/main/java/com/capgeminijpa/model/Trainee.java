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
@Table(name = "traineedetails")
public class Trainee 
{
	@Id
	@GeneratedValue
	private int traineeId;
	private String traineeName;

	@ManyToMany
	@JoinTable(name = "Trainee_Course", joinColumns = { @JoinColumn(name = "traineeId") }, inverseJoinColumns = {
			@JoinColumn(name = "courseId") })
	Set<Course> courseSet = new HashSet<Course>();

	public Trainee() {
	}

	public Trainee(int traineeId, String traineeName, Set<Course> courseSet) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.courseSet = courseSet;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}
}
