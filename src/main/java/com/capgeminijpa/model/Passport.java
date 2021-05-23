package com.capgeminijpa.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "passportTable")
public class Passport {
	@Id
	private int passportId;

	@Temporal(TemporalType.DATE)
	private Date issuedDate;
	@Column(name = "loc", length = 30)
	private String issuedlocation;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "personid")
	private Person person;

	public Passport() {
	}

	public Passport(int passportId, Date issuedDate, String issuedlocation) {
		super();
		this.passportId = passportId;
		this.issuedDate = issuedDate;
		this.issuedlocation = issuedlocation;
	}

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getIssuedlocation() {
		return issuedlocation;
	}

	public void setIssuedlocation(String issuedlocation) {
		this.issuedlocation = issuedlocation;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", issuedDate=" + issuedDate + ", issuedlocation="
				+ issuedlocation + ", person=" + person + "]";
	}
}
