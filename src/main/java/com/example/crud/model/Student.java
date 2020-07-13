package com.example.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	@NotBlank
	@Size(min = 3, max = 32)
	private String firstName;

	@Column(name = "lastname")
	@NotBlank
	@Size(min = 3, max = 32)
	private String lastName;

	@Column(name = "email")
	@NotBlank(message = "ป้อนอีเมล์ก่อน")
	@Email(message = "รูปแบบอีเมล์ไม่ถูกต้อง")
	private String email;

	@Column(name = "country")
	@NotBlank
	private String country;

	@Column(name = "sex")
	@NotEmpty
	private String sex;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "section")
	@NotEmpty
	private String section;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
