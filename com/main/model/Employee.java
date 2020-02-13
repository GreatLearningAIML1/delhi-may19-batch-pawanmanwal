package com.main.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = -1232395859408322328L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ", allocationSize = 1)
	private long id;

	@NotEmpty(message = "Please provide First Name")
	@Column(name = "FIRST_NAME")
	@Size(min = 1, max = 35, message = "First name cannot be longer than 35 characters")
	private String firstName;

	@NotEmpty(message = "Please provide Last Name")
	@Column(name = "LAST_NAME")
	@Size(min = 1, max = 35, message = "Last name cannot be longer than 35 characters")
	private String lastName;

	@Column(name = "JOB_TITLE")
	@NotEmpty(message = "Please provide Job Title")
	@Size(min = 1, max = 50)
	private String jobTitle;

	@NotNull(message = "Please provide Start Date")
	@Column(name = "STARTDATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull(message = "Please provide End Date")
	@Column(name = "ENDDATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	public Employee() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jobTitle=" + jobTitle
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	public Employee(long id, String firstName, String lastName, String jobTitle, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
