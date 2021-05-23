package com.capgeminijpa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "personTable")
public class Person 
{
	@Id
	private int personId;
	@Column(name = "p_name", length = 30)
	private String personName;
	private long phno;
	@Temporal(TemporalType.DATE)
	private Date dob;

	@OneToOne(mappedBy="person",fetch=FetchType.LAZY,cascade=CascadeType.ALL) // passport Id in person table
	private Passport passport;

	public Person() {
	}

	public Person(int personId, String personName, long phno, Date dob) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.phno = phno;
		this.dob = dob;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", phno=" + phno + ", dob=" + dob + "]";
	}

}
